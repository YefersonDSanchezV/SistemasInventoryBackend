package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.RolDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Rol;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolMapper {
    RolDTO toDto(Rol rol);
    Rol toEntity(RolDTO dto);
}
