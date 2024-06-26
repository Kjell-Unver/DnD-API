package com.example.dndapi.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder(toBuilder = true)
@RequiredArgsConstructor(onConstructor_ = @JsonCreator)
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class ItemsDto {

    @JsonProperty(required = true)
    private final String name;
    @JsonProperty(required = true)
    private final String description;
    @JsonProperty(required = true)
    private final Integer value;
}
