package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioServices {
    UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);
    UsuarioDTO editarUsuario(String identificacion, UsuarioDTO usuarioDTO);
    UsuarioDTO consultarPorIdentificacion(String identificacion);
    List<UsuarioDTO> consultarPorEstado(String estado);
    List<UsuarioDTO> listarTodos();
}
