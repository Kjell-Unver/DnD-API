package com.example.dndapi.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder(toBuilder = true)
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
