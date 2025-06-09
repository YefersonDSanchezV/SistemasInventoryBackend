package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.AsignacionDTO;

import java.util.List;

public interface AsignacionService {
    AsignacionDTO registrarAsignacion(AsignacionDTO dto);
    List<AsignacionDTO> consultarAsignaciones();
    AsignacionDTO consultarPorNombrePersona(String nombrePersona);
    AsignacionDTO editarAsignacion(String nombrePersona, AsignacionDTO dto);
    List<AsignacionDTO> obtenerAsignacionCompleta();
}
