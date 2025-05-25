package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventarioDTO {
    private Integer id;
    private String personaId;
    private String nombrePersona;
    private String celularPersona;
    private String estado;
    private String piso;
    private String ubicacion;
    private String placaActivoFijo;
    private LocalDateTime fechaRegistro;
    private Integer usuarioId;
}
