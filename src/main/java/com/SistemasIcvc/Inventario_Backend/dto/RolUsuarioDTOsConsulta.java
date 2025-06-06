package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RolUsuarioDTOsConsulta {
    private Integer id;
    private String nombreRol;
    private String nombreUsuario;
}
