package com.vkhalec.coffee_machine.exception_handling;

public class CoffeeException extends RuntimeException {

    public CoffeeException(String message) {
        super(message);
    }

    public CoffeeException(String ingredient, int need, int have) {
        super("Не хватает ингридиента: " + ingredient
                + ". Нужно для напитка: " + need + ". Есть в кофемашине: " + have + ".");
    }
}
