package com.vkhalec.coffee_machine.dao;

import com.vkhalec.coffee_machine.entity.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Integer> {
}
