package com.example.mvcproject.racinggame.controller;

import com.example.mvcproject.racinggame.car.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RacingGameController {
    private final Car car;

    @Autowired
    public RacingGameController(Car car) {
        this.car = car;
    }

    // http://localhost:8080/race
    @GetMapping("/race")
    @ResponseBody
    public String RaceStart(@RequestParam(defaultValue = "v6") String engine) {
        car.setEngine(engine);
        car.startCar();
        return "Race Started!";
    }
}
