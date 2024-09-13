package com.example.mvcproject.controller;

import com.example.mvcproject.domain.Login;
import com.example.mvcproject.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

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
    @RequestMapping("/login")
    public String login(Model model) {
        Login login = new Login();
        model.addAttribute("login", login);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute Login login, Model model) {
        User user = new User();
        System.out.println(login);
        if(login.getEmail().equals(user.getEmail()) && login.getPassword().equals(user.getPassword())) {
            model.addAttribute("name", user.getName());
            return "loginSuccess";
        }
        return "login";
    }
}
