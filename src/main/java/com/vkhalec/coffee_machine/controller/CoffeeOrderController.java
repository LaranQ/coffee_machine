package com.vkhalec.coffee_machine.controller;

import com.vkhalec.coffee_machine.entity.CoffeeOrder;
import com.vkhalec.coffee_machine.exception_handling.CoffeeIncorrectData;
import com.vkhalec.coffee_machine.service.CoffeeOrderService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(produces = "Предоставление интерфейса взаимодействия с таблицей coffee_order. Позволяет готовить кофе.")
@RestController
@RequestMapping("/coffee_order")
public class CoffeeOrderController {

    @Autowired
    private CoffeeOrderService service;

    @ApiOperation(value = "Получить сущность coffee_order по id", httpMethod = "GET",
            response = CoffeeOrder.class)
    @ApiImplicitParam(name = "id", value = "id")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Вернет сущность coffee_order", response = CoffeeOrder.class),
                    @ApiResponse(code = 404, message = "Вернет сообщение об ошибке", response = CoffeeIncorrectData.class)
            })
    @GetMapping("/{id}")
    public CoffeeOrder getCoffeeOrder(@PathVariable int id) {
        return service.getCoffeeOrder(id);
    }

    @ApiOperation(value = "Получить всех сущностей coffee_order", httpMethod = "GET",
            notes = "Получение сведенией о все сущностях в таблице coffee_order через сервисный класс", response = List.class)
    @ApiResponse(code = 200, message = "Вернет все сущности coffee_order", response = List.class)
    @GetMapping
    public List<CoffeeOrder> getAllCoffeeOrders() {
        return service.getAllCoffeeOrder();
    }

    @ApiOperation(value = "Абстрактное действие по приготовлению coffee в конкретной coffeeMachine", httpMethod = "POST",
            notes = "Фактически в таблицу coffee_order добавляется запись о том на какой машине какое кофе было приготовлено." +
                    "Операция возможна только если сущности coffee и coffee_machine существуют." +
                    "Если закончатся необходимые ингридиенты, то будет возвращено сообщение об ошибке с указанием каких " +
                    "ингредиентов не хватает.",
            response = CoffeeOrder.class)
    @ApiImplicitParam(name = "CoffeeOrder", value = "CoffeeOrder")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Вернет сущность coffee_machine", response = CoffeeOrder.class),
                    @ApiResponse(code = 404, message = "Вернет сообщение об ошибке", response = CoffeeIncorrectData.class)
            })
    @PostMapping
    public CoffeeOrder addOrder(@RequestBody CoffeeOrder coffeeOrder) {
        return service.saveCoffeeOrder(coffeeOrder);
    }
}