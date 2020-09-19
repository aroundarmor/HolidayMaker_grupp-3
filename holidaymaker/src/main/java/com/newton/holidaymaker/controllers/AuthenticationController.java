package com.newton.holidaymaker.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repositories.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthenticationController extends PageControllerEssentials {

    @Autowired
    private UserRepository userRepository;

    /**
    * Handles login requests.<br>
    * a user session will be started upon successful login.
    *
    * @return status message; "err#<i>statusMessageSample</i>" or "success"
    * */
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity loginUser(@RequestBody User loginForm, HttpServletRequest req) {
        HttpSession session = req.getSession();
        // The login process should be stopped when there's an active session.
        if(session.getAttribute("username") != null)
            return new ResponseEntity("err#activeSession", HttpStatus.OK);

        if(userRepository.existsByUsername(loginForm.getUsername()) == false)
            return new ResponseEntity("err#wuop", HttpStatus.OK); // wrong username or password

        // compare password
        User u = userRepository.findByUsername(loginForm.getUsername());
        boolean isCorrectPassword = BCrypt.checkpw(loginForm.getPassword(), u.getPassword());
        if(isCorrectPassword == false)
            return new ResponseEntity("err#wuop", HttpStatus.OK);

        session.setAttribute("username", loginForm.getUsername());
        return new ResponseEntity("success", HttpStatus.OK);
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
    	System.out.println("res status: " + res.getStatus());
        HttpSession session = req.getSession();
        if(session.getAttribute("username") != null)
            session.invalidate();
        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) { 
            new SecurityContextLogoutHandler().logout(req, res, auth);
        }
        
        redirect("/", res);    
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
