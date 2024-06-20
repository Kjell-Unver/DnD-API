package com.example.dndapi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class ItemsEntity {
    private final String name;
    private final String description;
    private final Integer value;
}
