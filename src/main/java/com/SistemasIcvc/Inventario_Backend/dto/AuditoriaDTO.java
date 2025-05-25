package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditoriaDTO {
    private Integer id;
    private Integer usuarioId;
    private Timestamp fecha;
    private String accion;
    private String detalles;
    private Integer equipoId;
}