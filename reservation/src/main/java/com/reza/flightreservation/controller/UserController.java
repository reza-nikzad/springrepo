package com.reza.flightreservation.controller;

import com.reza.flightreservation.entity.User;
import com.reza.flightreservation.repos.UserRepository;
import com.reza.flightreservation.service.SecurityService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/")
    public String showHomePage(){
        return "homePage";
    }

    @RequestMapping(value = "/showReg")
    public String showRegistrationPage(@ModelAttribute("user") User user){
        return "login/registerUser";
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    SecurityService securityService;


    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user, ModelMap modelMap){
        if(user.getFirstName().isBlank() ||
                user.getEmail().isBlank() ||
                user.getLastName().isBlank()
        ){
            LOGGER.info("Blank user is added");
            modelMap.addAttribute("msg", "fill all field");
            return "login/registerUser";
        }else{
            user.setPassword(encoder.encode(user.getPassword()));
            userRepository.save(user);
//            LOGGER.info("register(): User: " + user);
            modelMap.addAttribute("msg", "user is added");
            return "homePage";
        }

    }

    @RequestMapping(value = "/showLogin")
    public String showLoginPage(){
//        LOGGER.info("showLoginPage()");
        return "login/login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String logingIn(@RequestParam("email") String email,@RequestParam("password") String password, Model model ){
//        User user = userRepository.findByEmail(email);
        boolean loginResponse = securityService.login(email,password);
//        LOGGER.info("logingIn():Email:  "+ email);

        if(loginResponse){
            return "findFlights";
        }else{
//            LOGGER.info("logingIn():Wrong Email or Password");
            model.addAttribute("msg", "Wrong password or email address");
        }
        return "login/login";
    }

}
