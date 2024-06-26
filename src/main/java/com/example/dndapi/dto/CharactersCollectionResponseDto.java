package com.example.dndapi.dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class CharactersCollectionResponseDto {

    private final String id;
    private final String name;
    private final Integer level;
    private final String description;
}