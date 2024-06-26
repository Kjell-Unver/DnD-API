package com.example.dndapi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor(onConstructor_ = @JsonCreator)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class DnDCharacterDto {

    private final String id;
    @JsonProperty(required = true)
    private final String name;
    private final Integer level;
    private final String description;

    private final HpDto hp;

    private final SkillsDto skills;

    private final InventoryDto inventory;

    public Optional<SkillsDto> getSkills() {
        return Optional.ofNullable(skills);
    }

    public Optional<HpDto> getHp() {
        return Optional.ofNullable(hp);
    }

    public Optional<InventoryDto> getInventory() {
        return Optional.ofNullable(inventory);
    }

}