package com.SistemasIcvc.Inventario_Backend.mapper;


import com.SistemasIcvc.Inventario_Backend.dto.ComponenteDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Componente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ComponenteMapper {

    @Mapping(source = "computadora.id", target = "computadoraId")
    ComponenteDTO toDto(Componente componente);

    @Mapping(source = "computadoraId", target = "computadora.id")
    Componente toEntity(ComponenteDTO dto);
}

