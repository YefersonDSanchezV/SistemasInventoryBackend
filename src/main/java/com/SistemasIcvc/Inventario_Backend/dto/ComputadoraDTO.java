package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComputadoraDTO {
    private Integer id;
    private Integer equipoId;
    private String tipoEquipo;
    private String licenciaWindows;
    private String licenciaOffice;
    private String procesador;
    private String tipoDisco;
    private String capacidadDisco;
    private String memoriaRam;
    private String antivirus;
    private String sistemaOperativo;
}
