package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipoDTO {
    private Integer id;
    private String tipoEquipo;
    private String estado;
    private String ubicacion;
    private String placaAf;
    private String ip;
    private String nombreMaquina;
    private String directorioAdm;
    private String vidaUtil;
    private String mac;
    private String numeroOrdenCompra;
    private Integer fechaCompra;
    private Integer usuarioRegistra;
    private LocalDateTime fechaRegistro;

    private String nombreUsuario;
}
