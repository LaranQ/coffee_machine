package com.vkhalec.coffee_machine.service;

import com.vkhalec.coffee_machine.dao.CoffeeMachineRepository;
import com.vkhalec.coffee_machine.entity.Coffee;
import com.vkhalec.coffee_machine.entity.CoffeeMachine;
import com.vkhalec.coffee_machine.exception_handling.CoffeeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

    @Autowired
    private CoffeeMachineRepository repository;

    @Override
    public CoffeeMachine getCoffeeMachine(Integer id) {
        Optional<CoffeeMachine> optional = repository.findById(id);

        if (optional.isPresent())
            return optional.get();

        throw new CoffeeException("Указанная вами кофемашина не найдена.");
    }

    @Override
    public List<CoffeeMachine> getAllCoffeeMachine() {
        return repository.findAll();
    }

    @Override
    public CoffeeMachine saveCoffeeMachine(CoffeeMachine coffeeMachine) {

        return repository.save(coffeeMachine);
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public CoffeeMachine replaceCoffeeMachine(CoffeeMachine coffeeMachine) {

        Integer id = coffeeMachine.getId();

        if (id == null || !repository.findById(id).isPresent())
            throw new CoffeeException("Кофемашины с таким id не существует.");

        if(coffeeMachine.getName() == null)
            coffeeMachine.setName("default_name_" + id);

        return repository.save(coffeeMachine);
    }

    @Override
    public CoffeeMachine clearCoffeeMachine(CoffeeMachine idCoffeeMachine) {

        CoffeeMachine coffeeMachine = getCoffeeMachine(idCoffeeMachine.getId());

            coffeeMachine.setCountBeforeDirty(5);
            repository.save(coffeeMachine);

        return coffeeMachine;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public CoffeeMachine cookCoffee(Integer idCoffeeMachine, Coffee coffee) {

        CoffeeMachine machine = getCoffeeMachine(idCoffeeMachine);

            int timesToClear = machine.getCountBeforeDirty();

            if (timesToClear < 1)
                throw new CoffeeException("Машина грязная и на ней нельзя варить кофе.");

            int waterNeed = coffee.getWater();
            int waterHave = machine.getWater();

            if (waterNeed > waterHave)
                throw new CoffeeException("Вода", waterNeed, waterHave);

            int milkNeed = coffee.getMilk();
            int milkHave = machine.getMilk();

            if (milkNeed > milkHave)
                throw new CoffeeException("Молоко", milkNeed, milkHave);

            int beansNeed = coffee.getBeans();
            int beansHave = machine.getBeans();

            if (beansNeed > beansHave)
                throw new CoffeeException("Зерно", beansNeed, beansHave);

            machine.setWater(waterHave - waterNeed);
            machine.setMilk(milkHave - milkNeed);
            machine.setBeans(beansHave - beansNeed);
            machine.setCountBeforeDirty(--timesToClear);

            repository.save(machine);
            return machine;
    }
}
