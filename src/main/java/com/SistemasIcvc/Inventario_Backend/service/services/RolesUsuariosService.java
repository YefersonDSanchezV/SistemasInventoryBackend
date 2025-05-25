package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.RolUsuarioDTOsConsulta;
import com.SistemasIcvc.Inventario_Backend.dto.RolesUsuariosDTO;

import java.util.List;

public interface RolesUsuariosService {
    String asignarRolAUsuario(RolesUsuariosDTO rolesUsuariosDTO);
}
