package com.vkhalec.coffee_machine.entity;

import com.vkhalec.coffee_machine.exception_handling.CoffeeException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@ApiModel
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coffee_machine")
public class CoffeeMachine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @ApiModelProperty
    @Setter
    @Column(name = "name", nullable = false, length = 32)
    String name = "default_name";

    @ApiModelProperty
    @Setter
    @Column(name = "water", nullable = false)
    Integer water = 0;

    @ApiModelProperty
    @Setter
    @Column(name = "milk", nullable = false)
    Integer milk = 0;

    @ApiModelProperty
    @Setter
    @Column(name = "beans", nullable = false)
    Integer beans = 0;

    @ApiModelProperty(notes = "Количество кофе, которое можно приготовить до необходимости почистить кофемашину.")
    @Setter
    @Column(name = "count_before_dirty", nullable = false, insertable = false)
    Integer countBeforeDirty = 5;
}