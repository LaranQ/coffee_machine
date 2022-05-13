package com.vkhalec.coffee_machine.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.Instant;

@ApiModel
@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coffee_orders")
public class CoffeeOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @ApiModelProperty
    Integer id;

    @ApiModelProperty
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coffee")
    Coffee coffee;

    @ApiModelProperty
    @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "coffee_machine")
    CoffeeMachine coffeeMachine;

    @ApiModelProperty
    @Column(name = "date", nullable = false, updatable = false, insertable = false)
    Instant date;
}