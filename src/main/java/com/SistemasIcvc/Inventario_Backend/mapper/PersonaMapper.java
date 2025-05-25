package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.PersonaDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Persona;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonaMapper {
    PersonaDTO toDto(Persona persona);

    @Mapping(target = "id", ignore = true)
    Persona toEntity(PersonaDTO dto);
    }
