package com.example.dndapi.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.EqualsAndHashCode;


@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateCharacterResponseDto {
    private final String id;
    //private final String level;

}
