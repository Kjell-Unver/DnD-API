package com.example.dndapi.entity;


import com.example.dndapi.dto.HpDto;
import com.example.dndapi.dto.InventoryDto;
import com.example.dndapi.dto.SkillsDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@Document(collection="dnd.Character")
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@EqualsAndHashCode
public class CharacterEntity {
    @Id
    private String id;

    private final SkillsEntity skills;

    private final String name;

    private final String description;
    private final Integer level;

    private final HpEntity hp;

    private final InventoryEntity inventory;
}
