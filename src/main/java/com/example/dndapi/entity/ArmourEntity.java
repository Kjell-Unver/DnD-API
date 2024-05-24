package com.example.dndapi.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ArmourEntity {
    private final Integer armour_class;
    private final String armour_desc;
}
