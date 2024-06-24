package com.example.dndapi.mapper;

import com.example.dndapi.dto.ArmourDto;
import com.example.dndapi.entity.ArmourEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArmourDTOMapper {

    ArmourDTOMapper INSTANCE = Mappers.getMapper(ArmourDTOMapper.class);

    ArmourEntity armourDTOtoArmourEntity(final ArmourDto armourDto);
    ArmourDto armourEntitytoArmourDTO(final ArmourEntity armourEntity);
}
