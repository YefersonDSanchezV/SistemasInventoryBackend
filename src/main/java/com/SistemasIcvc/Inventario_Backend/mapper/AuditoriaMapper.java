package com.SistemasIcvc.Inventario_Backend.mapper;

import com.SistemasIcvc.Inventario_Backend.dto.AuditoriaDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Auditoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuditoriaMapper {
    AuditoriaDTO toDto(Auditoria auditoria);
    Auditoria toEntity(AuditoriaDTO dto);
}
