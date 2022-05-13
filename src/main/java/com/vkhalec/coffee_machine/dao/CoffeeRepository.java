package com.vkhalec.coffee_machine.dao;

import com.vkhalec.coffee_machine.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {
}
