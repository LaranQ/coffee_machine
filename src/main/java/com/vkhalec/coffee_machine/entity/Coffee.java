package com.vkhalec.coffee_machine.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@ApiModel
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coffee")
public class Coffee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty
    Integer id;

    @Column(name = "name", length = 16, nullable = false)
    @ApiModelProperty
    String name;

    @ApiModelProperty(notes = "Минимальное количество воды для варки кофе.")
    @Column(name = "water", nullable = false)
    Integer water;

    @ApiModelProperty(notes = "Минимальное количество молока для варки кофе.")
    @Column(name = "milk", nullable = false)
    Integer milk;

    @ApiModelProperty(notes = "Минимальное количество бобов для варки кофе.")
    @Column(name = "beans", nullable = false)
    Integer beans;
}