package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.AuditoriaDTO;

import java.util.List;

public interface AuditoriaService {
    AuditoriaDTO registrar(AuditoriaDTO dto);
    AuditoriaDTO consultarPorId(Long id);
    List<AuditoriaDTO> listar();
}
