package com.example.application.healthcheck;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(path = "actuator/healthcheck")
public class Healthcheck {

    @GetMapping
    public String getPayslip() {
        return "ok";
    }
}