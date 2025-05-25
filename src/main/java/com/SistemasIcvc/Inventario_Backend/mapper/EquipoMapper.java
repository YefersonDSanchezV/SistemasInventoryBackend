package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipoMapper {

    EquipoDTO toDto(Equipo equipo);

    Equipo toEntity(EquipoDTO dto);
}
