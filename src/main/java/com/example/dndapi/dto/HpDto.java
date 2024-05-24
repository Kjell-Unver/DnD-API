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
public class HpDto {
    private final Integer curr_hp;
    private final Integer max_hp;
}
