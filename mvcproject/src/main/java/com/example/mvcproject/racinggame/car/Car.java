package com.example.mvcproject.racinggame.car;

import com.example.mvcproject.racinggame.engine.Engine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;

@Component
@RequestScope
public class Car {

    private final Map<String, Engine> engines;
    private Engine engine;

    @Autowired
    public Car(Map<String, Engine> engines) {
        this.engines = engines;
    }

    public void setEngine(String engineType) {
        this.engine = engines.get(engineType.toLowerCase() + "Engine");
    }

    public void startCar() {
        System.out.println(engine.start());
    }
}
