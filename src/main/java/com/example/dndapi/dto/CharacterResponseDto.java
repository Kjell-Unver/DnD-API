package com.example.dndapi.dto;


import com.example.dndapi.entity.InventoryEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CharacterResponseDto {
    private final String id;
    private final String name;
    private final Integer level;
    private final String description;

    private final HpDto hp;

    private final SkillsDto skills;

    private final InventoryDto inventory;


}
