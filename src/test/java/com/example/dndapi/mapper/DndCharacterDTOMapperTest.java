package com.example.dndapi.mapper;

import com.example.dndapi.dto.ArmourDto;
import com.example.dndapi.dto.DnDCharacterDto;
import com.example.dndapi.dto.HpDto;
import com.example.dndapi.dto.InventoryDto;
import com.example.dndapi.dto.SkillsDto;
import com.example.dndapi.dto.WeaponDto;
import com.example.dndapi.entity.ArmourEntity;
import com.example.dndapi.entity.CharacterEntity;
import com.example.dndapi.entity.HpEntity;
import com.example.dndapi.entity.InventoryEntity;
import com.example.dndapi.entity.SkillsEntity;
import com.example.dndapi.entity.WeaponEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

class DndCharacterDTOMapperTest {
    private DndCharacterDTOMapper testee;

    @BeforeEach
    void setUp() {
        testee = Mappers.getMapper(DndCharacterDTOMapper.class);
    }

    @Test
    public void shouldConvertDndCharacterDTO() {
        // given
        final HpDto givenHpDto = HpDto.builder()
                .curr_hp(10)
                .max_hp(100)
                .build();
        final SkillsDto givneSkillsDto = SkillsDto.builder()
                .charisma(10)
                .constitution(10)
                .dexterity(5)
                .intelligence(3)
                .wisdom(1)
                .strength(100)
                .build();
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

        final DnDCharacterDto givenCharacterDto = DnDCharacterDto.builder()
                .name("aName")
                .level(1)
                .hp(givenHpDto)
                .skills(givneSkillsDto)
                .inventory(givenInventoryDto)
                .build();

        // when
        final CharacterEntity result = testee.characterDTOtoCharacterEntity(givenCharacterDto);

        // then
        final HpEntity expectedHpEntity = HpEntity.builder()
                .curr_hp(10)
                .max_hp(100)
                .build();
        final SkillsEntity expectedSkillsEntity = SkillsEntity.builder()
                .charisma(10)
                .constitution(10)
                .dexterity(5)
                .intelligence(3)
                .wisdom(1)
                .strength(100)
                .build();
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

        final CharacterEntity expectedCharacterEntity = CharacterEntity.builder()
                .id(null)
                .name("aName")
                .level(1)
                .hp(expectedHpEntity)
                .skills(expectedSkillsEntity)
                .inventory(expectedInventoryEntity)
                .build();



        assertThat(result)
                .usingRecursiveComparison()
                .isEqualTo(expectedCharacterEntity);
    }
}