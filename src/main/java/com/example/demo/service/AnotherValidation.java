package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service(value = "AnotherValidaton")
public class AnotherValidation implements IValidation{

    @Override
    public Boolean validate(String source) {
        System.out.println("Executing another validation");
        return true;
    }
}
