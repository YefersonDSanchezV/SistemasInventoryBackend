package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CamaraDTO {
    private Integer id;
    private Integer equipoId;
    private String nvrRelacionado;
    private String nombreCamara;
    private String poe;
}