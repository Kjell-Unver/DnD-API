package com.example.dndapi.mapper;

import com.example.dndapi.dto.ArmourDto;
import com.example.dndapi.dto.InventoryDto;
import com.example.dndapi.dto.WeaponDto;
import com.example.dndapi.entity.ArmourEntity;
import com.example.dndapi.entity.InventoryEntity;
import com.example.dndapi.entity.WeaponEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class InventoryDTOMapperTest {
    private InventoryDTOMapper testee;

    @BeforeEach
    void setUp() {
        testee = Mappers.getMapper(InventoryDTOMapper.class);

    }

    @Test
    public void testWeaponDTOtoWeaponEntity() {
        // given
        final InventoryDto givenInventoryDto = InventoryDto.builder()
                .weapon(WeaponDto.builder()
                        .weapon_value(100)
                        .weapon_desc("Axe")
                        .build())
                .armour(ArmourDto.builder()
                        .armour_class(10)
                        .armour_desc("Plate")
                        .build())
                .potion("Healing")
                .build();

        // when
        final InventoryEntity result = testee.inventoryDTOtoInventoryEntity(givenInventoryDto);

        // then
        final InventoryEntity expectedInventoryEntity = InventoryEntity.builder()
                .weapon(WeaponEntity.builder()
                        .weapon_value(100)
                        .weapon_desc("Axe")
                        .build())
                .armour(ArmourEntity.builder()
                        .armour_class(10)
                        .armour_desc("Plate")
                        .build())
                .potion("Healing")
                .build();


        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(expectedInventoryEntity);
    }
}