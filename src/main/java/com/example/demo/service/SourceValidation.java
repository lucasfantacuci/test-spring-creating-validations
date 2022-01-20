package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service(value = "SourceValidation")
public class SourceValidation implements IValidation{
    @Override
    public Boolean validate(String source) {
        System.out.println("Executing source validation");
        return true;
    }
}
