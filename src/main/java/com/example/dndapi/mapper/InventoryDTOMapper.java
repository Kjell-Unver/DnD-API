package com.example.dndapi.mapper;

import com.example.dndapi.dto.InventoryDto;
import com.example.dndapi.dto.ItemsDto;
import com.example.dndapi.entity.InventoryEntity;
import org.mapstruct.Condition;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {WeaponDTOMapper.class, ArmourDTOMapper.class})
public interface InventoryDTOMapper {

    InventoryDTOMapper INSTANCE = Mappers.getMapper(InventoryDTOMapper.class);

    InventoryEntity inventoryDTOtoInventoryEntity(final InventoryDto inventoryDto);
    InventoryDto inventoryEntitytoInventoryDTO(final InventoryEntity inventoryEntity);

    @Condition
    default boolean isNotNull(final List<ItemsDto> itemsDtos) {
        return itemsDtos != null && !itemsDtos.isEmpty();
    }
}
