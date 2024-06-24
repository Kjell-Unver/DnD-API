package com.example.dndapi.mapper;

import com.example.dndapi.dto.DnDCharacterDto;
import com.example.dndapi.entity.CharacterEntity;
import com.example.dndapi.entity.HpEntity;
import com.example.dndapi.entity.InventoryEntity;
import com.example.dndapi.entity.SkillsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {InventoryDTOMapper.class, HpDTOMapper.class, SkillsDTOMapper.class})
public interface DndCharacterDTOMapper {
    DndCharacterDTOMapper INSTANCE = Mappers.getMapper(DndCharacterDTOMapper.class);

    @Mapping(target = "hp", expression = "java(mapHpOptional(characterDto))")
    @Mapping(target = "skills", expression = "java(mapSkillsOptional(characterDto))")
    @Mapping(target = "inventory", expression = "java(mapInventoryOptional(characterDto))")
    CharacterEntity characterDTOtoCharacterEntity(final DnDCharacterDto characterDto);
    DnDCharacterDto characterEntityToCharacterDTO(final CharacterEntity characterEntity);

    default HpEntity mapHpOptional(final DnDCharacterDto characterDto) {
        return characterDto.getHp()
                .map(HpDTOMapper.INSTANCE::hpDTOtoHpEntity)
                .orElse(null);
    }

    default SkillsEntity mapSkillsOptional(final DnDCharacterDto characterDto) {
        return characterDto.getSkills()
                .map(SkillsDTOMapper.INSTANCE::skillsDTOtoSkillsEntity)
                .orElse(null);
    }

    default InventoryEntity mapInventoryOptional(final DnDCharacterDto characterDto) {
        return characterDto.getInventory()
                .map(InventoryDTOMapper.INSTANCE::inventoryDTOtoInventoryEntity)
                .orElse(null);
    }

}
