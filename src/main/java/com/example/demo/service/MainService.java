package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

@Service
public class MainService {

    @Autowired
    private Set<IValidation> validations;

    public void chainOfValidationOne(){
        var validationsForChainOne = Arrays.asList("BadlistValidation"); // get this from database

        Flux.fromIterable(validations)
            .filter(iValidation ->
                validationsForChainOne.contains(
                    iValidation.getClass().getAnnotation(Service.class).value()))
            .parallel()
            .doOnNext(iValidation -> iValidation.validate("dataToValidate"))
            .subscribe();
    }

    public void chainOfValidationTwo(){
        var validationsForChainOne = Arrays.asList("BadlistValidation", "AnotherValidaton");

        Flux.fromIterable(validations)
            .filter(iValidation ->
                validationsForChainOne.contains(
                    iValidation.getClass().getAnnotation(Service.class).value()))
            .parallel()
            .doOnNext(iValidation -> iValidation.validate("dataToValidate"))
            .subscribe();
    }
}
