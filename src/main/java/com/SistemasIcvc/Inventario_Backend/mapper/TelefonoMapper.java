package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.TelefonoDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Telefono;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TelefonoMapper {
    TelefonoDTO toDto(Telefono telefono);
    Telefono toEntity(TelefonoDTO dto);
}
