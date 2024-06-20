package com.example.dndapi.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.management.modelmbean.RequiredModelMBean;
import java.lang.reflect.Array;
import java.util.Optional;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor(onConstructor_ = @JsonCreator)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class DnDCharacterDto {

    private final SkillsDto skills;

    @JsonProperty(required = true)
    private final String name;

    private final String description;
    private final Integer level;

    private final HpDto hp;

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



//    public InventoryDto getInventory() {
//        return inventory;
//    }
}