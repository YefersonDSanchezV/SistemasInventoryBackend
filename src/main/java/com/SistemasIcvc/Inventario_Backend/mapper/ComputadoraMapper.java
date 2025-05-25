package com.SistemasIcvc.Inventario_Backend.mapper;


import com.SistemasIcvc.Inventario_Backend.dto.ComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Computadora;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComputadoraMapper {
    ComputadoraDTO toDto(Computadora computadora);
    Computadora toEntity(ComputadoraDTO dto);
}
