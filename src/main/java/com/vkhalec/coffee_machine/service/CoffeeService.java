package com.vkhalec.coffee_machine.service;

import com.vkhalec.coffee_machine.entity.Coffee;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getAllCoffee();

    Coffee getCoffee(Integer id);
}
