package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.InventarioDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Inventario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InventarioMapper {

    InventarioDTO toDto(Inventario inventario);

    Inventario toEntity(InventarioDTO dto);
}
