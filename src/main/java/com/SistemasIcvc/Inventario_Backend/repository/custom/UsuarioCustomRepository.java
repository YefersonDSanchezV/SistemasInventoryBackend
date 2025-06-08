package com.SistemasIcvc.Inventario_Backend.repository.custom;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.UsuariosCompletosDTO;

import java.util.List;

public interface UsuarioCustomRepository {
    List<UsuariosCompletosDTO> consultarUsuarioCompleto();
}
