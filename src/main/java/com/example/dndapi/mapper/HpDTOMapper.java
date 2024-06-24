package com.example.dndapi.mapper;

import com.example.dndapi.dto.HpDto;
import com.example.dndapi.entity.HpEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HpDTOMapper {

    HpDTOMapper INSTANCE = Mappers.getMapper(HpDTOMapper.class);

    HpEntity hpDTOtoHpEntity(final HpDto hpDto);
    HpDto hpEntitytoHpDTO(final HpEntity hpEntity);
}
