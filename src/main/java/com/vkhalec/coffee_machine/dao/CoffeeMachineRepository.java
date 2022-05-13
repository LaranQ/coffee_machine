package com.vkhalec.coffee_machine.dao;

import com.vkhalec.coffee_machine.entity.CoffeeMachine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeMachineRepository extends JpaRepository<CoffeeMachine, Integer> {
}
