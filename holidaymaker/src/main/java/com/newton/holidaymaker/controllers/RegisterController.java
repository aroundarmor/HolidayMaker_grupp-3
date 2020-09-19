package com.newton.holidaymaker.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public HashMap<String, String> registerUser(@RequestBody User registerForm) {
        HashMap<String, String> response = new HashMap<String, String>();
        List<String> errors = new ArrayList<String>();
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
        registerForm.setPhoneNumber(registerForm.getPhoneNumber());

        // Make sure there are no invalid characters ( anything other than a-zA-Z )
        // Only a-zA-Z allowed in first-, lastname fields.
        if(registerForm.getFirstname().matches(nameRegex) == false)
            errors.add("fname");

        if(registerForm.getLastname().matches(nameRegex) == false)
            errors.add("lname");

        if(registerForm.getUsername().matches(usernameRegex) == false)
            errors.add("uname");

        // validate email with apache-commons validator
        // NOTE : returns valid on '€##/&/email@abc.xyz', might need to use regex later.
        EmailValidator emailValidator = EmailValidator.getInstance();
        if(emailValidator.isValid(registerForm.getEmail()) == false)
            errors.add("email");

        // Email & usernames must be unique or conflicts may arise.
        if(userRepository.existsByUsername(registerForm.getUsername()))
            errors.add("unameTaken");

        if(userRepository.existsByEmail(registerForm.getEmail()))
            errors.add("emailTaken");

        // Encrypt & update password
        String pw_hash = BCrypt.hashpw(registerForm.getPassword(), BCrypt.gensalt());
        registerForm.setPassword(pw_hash);


        // TODO : set default roles & permissions
        // register account if there are no errors found.
        if(errors.size() == 0) {
            userRepository.save(registerForm);
            System.out.println("Created: " + registerForm.getFirstname());
        }

        // prepare and return response object
        response.put("status", (errors.size() > 0 ? "failure":"success"));
        response.put("errors", errors.toString());

        return response;
    }
}
