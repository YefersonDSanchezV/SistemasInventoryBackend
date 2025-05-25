package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.TelefonoDTO;

import java.util.List;

public interface TelefonoService {
    TelefonoDTO registrar(TelefonoDTO dto);
    TelefonoDTO editar(Long id, TelefonoDTO dto);
    TelefonoDTO consultarPorId(Long id);
    List<TelefonoDTO> listar();
}
