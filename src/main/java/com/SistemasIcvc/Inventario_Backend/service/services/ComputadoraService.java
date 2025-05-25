package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.ComputadoraDTO;

import java.util.List;

public interface ComputadoraService {
    ComputadoraDTO registrar(ComputadoraDTO dto);
    ComputadoraDTO editar(Long id, ComputadoraDTO dto);
    ComputadoraDTO consultarPorId(Long id);
    List<ComputadoraDTO> listar();
}
