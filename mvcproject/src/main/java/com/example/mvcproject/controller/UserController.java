package com.example.mvcproject.controller;

import com.example.mvcproject.domain.User;
import com.example.mvcproject.service.LoggedUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private LoggedUserManagementService loggedUserManagementService;

    // http://localhost:8080/user/signup
    @RequestMapping("/signup")
    public String signup(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "signup";
    }

//    @RequestMapping(value = "/signup", method = RequestMethod.POST)
//    @ResponseBody
//    public String signup(@ModelAttribute User user) {
//        System.out.println("user = " + user);
//        return "success";
//    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signup(@ModelAttribute User user) {
        System.out.println("user = " + user);
//        return "redirect:/user/signup";
        return "redirect:http://localhost:8080/user/signup";
    }

    // http://localhost:8080/user/login
//    @RequestMapping("/login")
//    public String login(Model model) {
//        Login login = new Login();
//        model.addAttribute("login", login);
//        return "login";
//    }
//
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String login(@ModelAttribute Login login, Model model) {
//        User user = new User();
//        System.out.println(login);
//        if(login.getEmail().equals(user.getEmail()) && login.getPassword().equals(user.getPassword())) {
//            model.addAttribute("name", user.getName());
//            return "loginSuccess";
//        }
//        return "login";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String email,
            @RequestParam String password,
            Model model
    ) {
        System.out.println("email = " + email);
        System.out.println("password = " + password);
        User user = new User();
        if(email.equals(user.getEmail()) && password.equals(user.getPassword())) {
            loggedUserManagementService.setUserName(user.getName());
            model.addAttribute("message", "Login success");
            return "redirect:/main";
        } else {
            model.addAttribute("message", "Login failed");
        }
        return "login";
    }
}
