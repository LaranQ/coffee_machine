package com.vkhalec.coffee_machine.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CoffeeMachineGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<CoffeeIncorrectData> handleException(CoffeeException exception) {

        CoffeeIncorrectData data = new CoffeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CoffeeIncorrectData> handleException(Throwable exception) {

        CoffeeIncorrectData data = new CoffeeIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
