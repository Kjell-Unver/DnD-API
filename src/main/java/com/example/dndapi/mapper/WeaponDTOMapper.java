package com.example.dndapi.mapper;

import com.example.dndapi.dto.WeaponDto;
import com.example.dndapi.entity.WeaponEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WeaponDTOMapper {

    WeaponDTOMapper INSTANCE = Mappers.getMapper(WeaponDTOMapper.class);

    WeaponEntity weaponDTOtoWeaponEntity(final WeaponDto weaponDto);
    WeaponDto weaponEntitytoWeaponDTO(final WeaponEntity weaponEntity);

}
