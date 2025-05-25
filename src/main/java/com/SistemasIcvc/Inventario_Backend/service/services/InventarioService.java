package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.InventarioDTO;

import java.util.List;

public interface InventarioService {
    InventarioDTO registrar(InventarioDTO dto);
    InventarioDTO editar(Long id, InventarioDTO dto);
    InventarioDTO consultarPorId(Long id);
    List<InventarioDTO> listar();
}
