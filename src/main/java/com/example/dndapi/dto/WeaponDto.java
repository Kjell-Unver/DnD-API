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
public class WeaponDto {
    private final Integer weapon_value;
    private final String weapon_desc;
}
