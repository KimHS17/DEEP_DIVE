package com.example.Race.controller;

import com.example.Race.domain.Car;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RacingGameController {

    // http://localhost:8080/race
    @RequestMapping("/race")
    @ResponseBody
    public String RaceStart() {
        Car car = new Car();
        System.out.println(car.getEngine().start());
        return car.getEngine().start();
    }
}
