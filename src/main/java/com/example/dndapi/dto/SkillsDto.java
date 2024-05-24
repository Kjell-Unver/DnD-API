package com.example.dndapi.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;



@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor(onConstructor_ = @JsonCreator)
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class SkillsDto {

    private final Integer strength;
    private final Integer dexterity;
    private final Integer constitution;
    private final Integer intelligence;
    private final Integer wisdom;
    private final Integer charisma;
}
