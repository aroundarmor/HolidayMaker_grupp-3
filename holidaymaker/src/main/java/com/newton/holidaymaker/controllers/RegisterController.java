package com.newton.holidaymaker.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.newton.holidaymaker.models.User;
import com.newton.holidaymaker.repositories.UserRepository;

@RestController
public class RegisterController extends PageControllerEssentials implements PageControllerInterface {

    @GetMapping("/register")
    @Override
    public ModelAndView run(HttpServletRequest req, HttpServletResponse res, Principal principal) {

        // Redirect already-logged-in users to index
        if(principal != null) {
            redirect("/", res);
            return null;
        }

        ModelAndView mv = initModelAndView("HolidayMaker | Register Account", "register", "register");
        return mv;
    }

    @Autowired
    private UserRepository userRepository;

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

        // Matches only numbers in a string.
        String onlyNumbers = "^[0-9]*$";

        // Matches (a-zA-Z) (0-9) (. -)
        // allowed username patterns;
        // us.er_name, user_name1, user.name.1
        // user.name.1, 1user.name, user_name_1
        String usernameRegex = "^(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";

        // Trim first & lastname;
        // sometimes users may, by mistake, input ' text ' or 'text   '
        registerForm.setFirstname(registerForm.getFirstname().trim().toLowerCase());
        registerForm.setLastname(registerForm.getLastname().trim().toLowerCase());
        registerForm.setEmail(registerForm.getEmail().trim().toLowerCase());
        registerForm.setUsername(registerForm.getUsername().trim().toLowerCase());
        reigsterForm.setPhoneNumber(registerForm.getPhoneNumber().trim());

        // Make sure there are no invalid characters ( anything other than a-zA-Z )
        // Only a-zA-Z allowed in first-, lastname fields.
        if(registerForm.getFirstname().matches(nameRegex) == false)
            return "err#fnameInvalid";

        if(registerForm.getLastname().matches(nameRegex) == false)
            return "err#lnameInvalid";

        if(registerForm.getUsername().matches(usernameRegex) == false)
            return "err#unameInvalid";

        if(registerForm.getPhoneNumber().matches(onlyNumbers) == false)
            return "err#invalidPhone";

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

        // TODO : set default roles & permissions

        // register account
        userRepository.save(registerForm);
        System.out.println("Created: " + registerForm.getFirstname());
        return "success";
    }
}
