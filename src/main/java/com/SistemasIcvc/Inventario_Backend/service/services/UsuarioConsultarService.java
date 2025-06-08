package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.UsuariosCompletosDTO;

import java.util.List;

public interface UsuarioConsultarService {
    List<UsuariosCompletosDTO> obtenerUsuariosCompletos();
}
