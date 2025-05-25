package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.CamaraDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Camara;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CamaraMapper {
    CamaraDTO toDto(Camara camara);
    Camara toEntity(CamaraDTO dto);
}
