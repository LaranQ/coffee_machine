package com.vkhalec.coffee_machine.controller;

import com.vkhalec.coffee_machine.entity.CoffeeMachine;
import com.vkhalec.coffee_machine.exception_handling.CoffeeIncorrectData;
import com.vkhalec.coffee_machine.service.CoffeeMachineService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(produces = "Предоставление интерфейса взаимодействия с таблицей coffee_machine.")
@RestController
@RequestMapping("/coffee_machine")
public class CoffeeMachineController {

    @Autowired
    private CoffeeMachineService service;

    @ApiOperation(value = "Получить сущность coffee_machine по id", httpMethod = "GET",
            response = CoffeeMachine.class)
    @ApiImplicitParam(name = "id", value = "id")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Вернет сущность coffee_machine", response = CoffeeMachine.class),
                    @ApiResponse(code = 404, message = "Вернет сообщение об ошибке", response = CoffeeIncorrectData.class)
            })
    @GetMapping("/{id}")
    public CoffeeMachine getCoffeeMachine(@PathVariable Integer id) {
        return service.getCoffeeMachine(id);
    }

    @ApiOperation(value = "Получить всех сущностей coffee_machine", httpMethod = "GET",
            notes = "Получение сведений о все сущностях в таблице coffee_machine через сервисный класс", response = List.class)
    @ApiResponse(code = 200, message = "Вернет все сущности coffee_machine", response = List.class)
    @GetMapping
    public List<CoffeeMachine> getAllCoffeeMachine() {
        return service.getAllCoffeeMachine();
    }

    @ApiOperation(value = "Добавить сущность coffeeMachine в базу данных", httpMethod = "POST",
            notes = "Добавление сущности возможно только если с таким id не существует. " +
                    "Все null поля будут заменены на default.",
            response = CoffeeMachine.class)
    @ApiImplicitParam(name = "coffeeMachine", value = "coffeeMachine")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Вернет сущность coffee_machine", response = CoffeeMachine.class),
                    @ApiResponse(code = 404, message = "Вернет сообщение об ошибке", response = CoffeeIncorrectData.class)
            })
    @PostMapping
    public CoffeeMachine addNewCoffeeMachine(@RequestBody CoffeeMachine coffeeMachine) {

        return service.saveCoffeeMachine(coffeeMachine);
    }

    @ApiOperation(value = "Обновить сущность coffeeMachine в базе данных", httpMethod = "PUT",
            notes = "Обновление сущности возможно только если сущность с таким id существует. " +
                    "Все null поля будут заменены на default.",
            response = CoffeeMachine.class)
    @ApiImplicitParam(name = "coffeeMachine", value = "coffeeMachine")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Вернет сущность coffee_machine", response = CoffeeMachine.class),
                    @ApiResponse(code = 404, message = "Вернет сообщение об ошибке", response = CoffeeIncorrectData.class)
            })
    @PutMapping
    public CoffeeMachine updateCoffeeMachine(@RequestBody CoffeeMachine coffeeMachine) {

        return service.replaceCoffeeMachine(coffeeMachine);
    }

    @ApiOperation(value = "Абстрактное действие по очистке coffeeMachine", httpMethod = "PUT",
            notes = "Обновление сущности возможно только если сущность с таким id существует. " +
                    "Фактически просто счетчик возможных операций по готовке кофе придет в состояние 5.",
            response = CoffeeMachine.class)
    @ApiImplicitParam(name = "coffeeMachine", value = "coffeeMachine")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Вернет сущность coffee_machine", response = CoffeeMachine.class),
                    @ApiResponse(code = 404, message = "Вернет сообщение об ошибке", response = CoffeeIncorrectData.class)
            })
    @PutMapping("/clear")
    public CoffeeMachine clear(@RequestBody CoffeeMachine coffeeMachine) {

        return service.clearCoffeeMachine(coffeeMachine);
    }
}
