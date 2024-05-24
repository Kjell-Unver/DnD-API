package com.example.dndapi.entity;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class SkillsEntity {
    private final Integer strength;
    private final Integer dexterity;
    private final Integer constitution;
    private final Integer intelligence;
    private final Integer wisdom;
    private final Integer charisma;
}
