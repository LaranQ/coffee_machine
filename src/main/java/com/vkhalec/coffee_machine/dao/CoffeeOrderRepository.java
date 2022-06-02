package com.vkhalec.coffee_machine.dao;

import com.vkhalec.coffee_machine.entity.CoffeeOrder;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Integer> {

    @Override
    @EntityGraph(attributePaths = {"coffee, coffeeMachine"})
    List<CoffeeOrder> findAll();
}
