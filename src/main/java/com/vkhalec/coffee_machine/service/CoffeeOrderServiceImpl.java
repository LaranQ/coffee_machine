package com.vkhalec.coffee_machine.service;

import com.vkhalec.coffee_machine.dao.CoffeeOrderRepository;
import com.vkhalec.coffee_machine.entity.Coffee;
import com.vkhalec.coffee_machine.entity.CoffeeMachine;
import com.vkhalec.coffee_machine.entity.CoffeeOrder;
import com.vkhalec.coffee_machine.exception_handling.CoffeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeOrderServiceImpl implements CoffeeOrderService {

    @Autowired
    private CoffeeOrderRepository repository;

    @Autowired
    private CoffeeService coffeeService;

    @Autowired
    private CoffeeMachineService coffeeMachineService;

    @Override
    public List<CoffeeOrder> getAllCoffeeOrder() {
        return repository.findAll();
    }

    @Override
    public CoffeeOrder getCoffeeOrder(int id){
        Optional<CoffeeOrder> optional = repository.findById(id);

        if(optional.isPresent())
            return optional.get();

        throw new CoffeeException("Заказа с таким id не существует.");
    }

    @Override
    public boolean isExist(Integer id) {
        return repository.existsById(id);
    }

    @Override
    public CoffeeOrder saveCoffeeOrder(CoffeeOrder coffeeOrder){

        Integer id = coffeeOrder.getId();

        if (id != null && isExist(id))
            throw new CoffeeException("Заказ с таким id уже существует.");

        Coffee coffee = coffeeService.getCoffee(coffeeOrder.getCoffee().getId());

        Integer idCoffeeMachine = coffeeOrder.getCoffeeMachine().getId();
        CoffeeMachine coffeeMachine = coffeeMachineService.cookCoffee(idCoffeeMachine, coffee);

        coffeeOrder.setCoffee(coffee);
        coffeeOrder.setCoffeeMachine(coffeeMachine);

        return repository.save(coffeeOrder);
    }
}
