package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.MovilDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Movil;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MovilMapper {
    MovilDTO toDto(Movil movil);
    Movil toEntity(MovilDTO dto);
}
