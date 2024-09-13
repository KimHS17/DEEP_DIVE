package com.example.Race.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Car {
    @Autowired @Qualifier("V6Engine")
    private Engine engine;

    public Engine getEngine() {
        return engine;
    }
}
