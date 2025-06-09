package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.AsignacionDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Asignacion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AsignacionMapper {

    @Mapping(source = "equipo.nombreMaquina", target = "nombreEquipo")
    @Mapping(source = "usuario.nombreUsuario", target = "nombreUsuario")
    AsignacionDTO toDto(Asignacion asignacion);

    Asignacion toEntity(AsignacionDTO dto);
}
