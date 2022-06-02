package com.vkhalec.coffee_machine.exception_handling;

public class CoffeeException extends RuntimeException {

    public CoffeeException(String message) {
        super(message);
    }

    public CoffeeException(String ingredient, int need, int have) {
        super("Не хватает ингредиента: " + ingredient
                + ". Нужно для напитка: " + need + ". Есть у кофемашины: " + have + ".");
    }
}
