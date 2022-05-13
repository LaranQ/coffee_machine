package com.vkhalec.coffee_machine.exception_handling;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

@ApiModel
@Getter
@Setter
public class CoffeeIncorrectData {

    private String info;

}
