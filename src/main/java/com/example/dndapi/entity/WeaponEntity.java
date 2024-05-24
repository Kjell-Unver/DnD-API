package com.example.dndapi.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class WeaponEntity {
    private final Integer weapon_value;
    private final String weapon_desc;
}