package com.newton.holidaymaker.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.crypto.bcrypt.BCrypt;

import org.apache.commons.validator.routines.EmailValidator;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Integer id) {
        return userRepository.findById(id).get();
    }

    /**
    * Handles login requests.<br>
    * a user session will be started upon successful login.
    *
    * @return status message; "err#<i>statusMessageSample</i>" or "success"
    * */
    @PostMapping("/login")
    @ResponseBody
    public String loginUser(@RequestBody User loginForm, HttpServletRequest req) {
        HttpSession session = req.getSession();
        // The login process should be stopped when there's an active session.
        if(session.getAttribute("username") != null)
            return "err#activeSession";

        if(userRepository.existsByUsername(loginForm.getUsername()) == false)
            return "err#wuop"; // wrong username or password

        // compare password
        User u = userRepository.findByUsername(loginForm.getUsername());
        boolean isCorrectPassword = BCrypt.checkpw(loginForm.getPassword(), u.getPassword());
        if(isCorrectPassword == false)
            return "err#wuop";

        session.setAttribute("username", loginForm.getUsername());
        return "success";
    }

    /**
    *
    * Handles logout requests.<br>
    * Active sessions are invalidated and the client is redirected to main page.
    *
    */
    @PostMapping("/logout")
    @ResponseBody
    public void logoutUser(HttpServletRequest req, HttpServletResponse res) {
        HttpSession session = req.getSession();
        if(session.getAttribute("username") != null)
            session.invalidate();

        // redirect user to home page
        res.setHeader("location", "/");
        res.setStatus(302);
    }

    /**
    *
    * Handles register requests.<br>
    * an account will be created if all conditions are met.
    *
    * @return status message; "err#<i>statusMessageSample</i>" or "success"
    *
    * */
    @PostMapping("/register")
    @ResponseBody
    public String registerUser(@RequestBody User registerForm) {

        // TODO : Implement config for better maintenance

        // Matches a-zA-Z
        // only alphabetic characters are allowed
        // for first- & lastname fields
        String nameRegex = "^[a-zA-Z]*$";

        // Matches (a-zA-Z) (0-9) (. -)
        // allowed username patterns;
        //      us.er_name
        //      user_name1
        //      user.name.1
        //      1user.name
        //      user_name_1
        String usernameRegex = "^(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";

        // Trim first & lastname;
        // sometimes users may, by mistake, input ' text ' or 'text   '
        registerForm.setFirstname(registerForm.getFirstname().trim().toLowerCase());
        registerForm.setLastname(registerForm.getLastname().trim().toLowerCase());
        registerForm.setEmail(registerForm.getEmail().trim().toLowerCase());
        registerForm.setUsername(registerForm.getUsername().trim().toLowerCase());

        // Make sure there are no invalid characters ( anything other than a-zA-Z )
        // Only a-zA-Z allowed in first-, lastname fields.
        if(registerForm.getFirstname().matches(nameRegex) == false)
            return "err#fnameInvalid";

        if(registerForm.getLastname().matches(nameRegex) == false)
            return "err#lnameInvalid";

        if(registerForm.getUsername().matches(usernameRegex) == false)
            return "err#unameInvalid";

        // validate email with apache-commons validator
        // NOTE : returns valid on '€##/&/email@abc.xyz', might need to use regex later.
        EmailValidator emailValidator = EmailValidator.getInstance();
        if(emailValidator.isValid(registerForm.getEmail()) == false)
            return "err#emailInvalid";

        // Email & usernames must be unique or conflicts may arise.
        if(userRepository.existsByUsername(registerForm.getUsername()))
            return "err#usernameTaken";
        else if(userRepository.existsByEmail(registerForm.getEmail()))
            return "err#emailTaken";

        // Encrypt & update password
        String pw_hash = BCrypt.hashpw(registerForm.getPassword(), BCrypt.gensalt());
        registerForm.setPassword(pw_hash);

        // Everything seems OK !
        // register account
        userRepository.save(registerForm);
        System.out.println("Created: " + registerForm.getFirstname());
        return "success";
    }
}
