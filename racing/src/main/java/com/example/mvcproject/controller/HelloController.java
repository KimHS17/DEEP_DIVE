package com.example.mvcproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping(value="/requestMappingGetTest", method = RequestMethod.GET)
    public String requestMappingGetTest(Model model) {
        model.addAttribute("textFromController", "World");
        model.addAttribute("textFromController2", "Icecream");
        return "requestHello";
    }

    // http://localhost:8080/requestParamTest?b=anyString
    // http://localhost:8080/requestParamTest?a=1&b=anyString&c=false
    @RequestMapping("/requestParamTest")
    public String requestParamTest(
            @RequestParam(name="a", required = false, defaultValue = "0") int a,
            @RequestParam("b") String b,
            @RequestParam(name="c", defaultValue = "true") boolean c
    ) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        return "hello";
    }

    // http://localhost:8080/requestParamMapTest?parma1=test1&param2=test2
    @RequestMapping("/requestParamMapTest")
    public String requestParamMapTest(
            @RequestParam Map<String, String> map
    ) {
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        return "hello";
    }

    // http://localhost:8080/pathVariableTest
    // http://localhost:8080/pathVariableTest/spring/test/complete
    // http://localhost:8080/pathVariableTest/spring/test/2024
    @RequestMapping("/pathVariableTest/{a}/{b}/{c}")
    public String pathVariableTest(
        @PathVariable(value="a") String a,
        @PathVariable String b,
        @PathVariable int c
    ) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        return "hello";
    }
}
