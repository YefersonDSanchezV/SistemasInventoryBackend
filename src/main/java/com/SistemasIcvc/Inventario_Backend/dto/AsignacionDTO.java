package com.SistemasIcvc.Inventario_Backend.dto;

import com.SistemasIcvc.Inventario_Backend.entity.Equipo;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignacionDTO {
    private String nombreEquipo;
    private String nombrePersona;
    private String nombreUsuario;
    private Integer usuarioId;
    private Equipo equipoDetalle;
}
