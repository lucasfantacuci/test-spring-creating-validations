package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service(value = "BadlistValidation")
public class BadlistValidation implements IValidation {

    @Override
    public Boolean validate(String source) {
        System.out.println("Executing badlist validation");
        return true;
    }
}
