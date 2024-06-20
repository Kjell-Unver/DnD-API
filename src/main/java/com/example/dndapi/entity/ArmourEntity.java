package com.example.dndapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class ArmourEntity {
    private final Integer armour_class;
    private final String armour_desc;
}
