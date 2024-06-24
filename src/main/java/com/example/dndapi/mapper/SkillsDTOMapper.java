package com.example.dndapi.mapper;

import com.example.dndapi.dto.SkillsDto;
import com.example.dndapi.entity.SkillsEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SkillsDTOMapper {

    SkillsDTOMapper INSTANCE = Mappers.getMapper(SkillsDTOMapper.class);

    SkillsEntity skillsDTOtoSkillsEntity(final SkillsDto skillsDto);
    SkillsDto skillsEntitytoSkillsDTO(final SkillsEntity skillsEntity);
}
