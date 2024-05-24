package com.example.dndapi.entity;

import com.example.dndapi.dto.ArmourDto;
import com.example.dndapi.dto.ItemsDto;
import com.example.dndapi.dto.WeaponDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class InventoryEntity {
    private final WeaponEntity weapon;
    private final ArmourEntity armour;
    private final String potion;

    @Builder.Default
    private final List<ItemsEntity> items=List.of();
}