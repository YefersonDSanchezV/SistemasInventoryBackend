package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.ImpresoraDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Impresora;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ImpresoraMapper {
    ImpresoraDTO toDto(Impresora impresora);
    Impresora toEntity(ImpresoraDTO dto);
}
