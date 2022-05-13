package com.vkhalec.coffee_machine.service;

import com.vkhalec.coffee_machine.dao.CoffeeRepository;
import com.vkhalec.coffee_machine.entity.Coffee;
import com.vkhalec.coffee_machine.exception_handling.CoffeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeRepository repository;

    @Override
    public List<Coffee> getAllCoffee() {
        return repository.findAll();
    }

    @Override
    public Coffee getCoffee(Integer id){
        Optional<Coffee> optional = repository.findById(id);

        if(optional.isPresent())
            return optional.get();

        throw new CoffeeException("Кофе с таким id не существует.");
    }
}