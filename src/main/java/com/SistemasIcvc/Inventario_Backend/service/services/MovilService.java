package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.MovilDTO;

import java.util.List;

public interface MovilService {
    MovilDTO registrar(MovilDTO dto);
    MovilDTO editar(Long id, MovilDTO dto);
    MovilDTO consultarPorId(Long id);
    List<MovilDTO> listar();
}
