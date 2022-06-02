package com.vkhalec.coffee_machine.controller;

import com.vkhalec.coffee_machine.entity.Coffee;
import com.vkhalec.coffee_machine.exception_handling.CoffeeIncorrectData;
import com.vkhalec.coffee_machine.service.CoffeeService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(produces = "Предоставление интерфейса взаимодействия с таблицей coffee")
@RestController
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    private CoffeeService service;

    @ApiOperation(value = "Получить сущность coffee по id", httpMethod = "GET", response = Coffee.class)
    @ApiImplicitParam(name = "id", value = "id")
    @ApiResponses(
            {
                    @ApiResponse(code = 200, message = "Вернет сущность coffee", response = Coffee.class),
                    @ApiResponse(code = 404, message = "Вернет сообщение об ошибке", response = CoffeeIncorrectData.class)
            })
    @GetMapping("/{id}")
    public Coffee getCoffee(@PathVariable int id) {
        return service.getCoffee(id);
    }

    @ApiOperation(value = "Получить всех сущностей coffee", httpMethod = "GET", notes = "Получение сведений о все сущностях в таблице coffee через сервисный класс")
    @ApiResponse(code = 200, message = "Вернет все сущности coffee", response = List.class)
    @GetMapping
    public List<Coffee> getAllCoffee() {
        return service.getAllCoffee();
    }

}
