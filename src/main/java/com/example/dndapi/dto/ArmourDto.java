package com.example.dndapi.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor(onConstructor_ = @JsonCreator)
@EqualsAndHashCode
public class ArmourDto {
    private final Integer armour_class;
    private final String armour_desc;
}
