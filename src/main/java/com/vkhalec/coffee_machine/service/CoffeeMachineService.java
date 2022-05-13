package com.vkhalec.coffee_machine.service;

import com.vkhalec.coffee_machine.entity.Coffee;
import com.vkhalec.coffee_machine.entity.CoffeeMachine;

import java.util.List;

public interface CoffeeMachineService {
    CoffeeMachine getCoffeeMachine(Integer id);

    List<CoffeeMachine> getAllCoffeeMachine();


    CoffeeMachine saveCoffeeMachine(CoffeeMachine coffeeMachine);

    CoffeeMachine replaceCoffeeMachine(CoffeeMachine coffeeMachine);

    CoffeeMachine clearCoffeeMachine(CoffeeMachine coffeeMachine);

    CoffeeMachine cookCoffee(Integer idCoffeeMachine, Coffee coffee);
}
