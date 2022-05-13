package com.vkhalec.coffee_machine.service;

import com.vkhalec.coffee_machine.entity.CoffeeOrder;

import java.util.List;

public interface CoffeeOrderService {
    List<CoffeeOrder> getAllCoffeeOrder();

    CoffeeOrder getCoffeeOrder(int id);

    boolean isExist(Integer id);

    CoffeeOrder saveCoffeeOrder(CoffeeOrder coffeeOrder);
}
