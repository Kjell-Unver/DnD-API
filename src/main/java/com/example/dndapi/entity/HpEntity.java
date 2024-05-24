package com.example.dndapi.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class HpEntity {
    private final Integer curr_hp;
    private final Integer max_hp;
}
