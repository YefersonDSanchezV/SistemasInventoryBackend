package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.ComponenteDTO;

import java.util.List;

public interface ComponenteService {
    ComponenteDTO registrar(ComponenteDTO dto);
    ComponenteDTO editar(Long id, ComponenteDTO dto);
    ComponenteDTO consultarPorId(Long id);
    List<ComponenteDTO> listarTodos();
    List<ComponenteDTO> listarPorTipo(String tipo);
}
