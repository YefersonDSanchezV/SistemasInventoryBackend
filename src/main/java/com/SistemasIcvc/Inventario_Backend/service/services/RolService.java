package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.RolDTO;

import java.util.List;

public interface RolService {
    RolDTO crearRol(RolDTO rolDTO);
    List<RolDTO> listarRoles();
}
