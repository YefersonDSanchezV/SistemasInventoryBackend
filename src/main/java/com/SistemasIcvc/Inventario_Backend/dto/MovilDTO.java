package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovilDTO {
    private Integer id;
    private Integer equipoId;
    private String celular;
    private String imei1;
    private String imei2;
    private String simCard;
    private String pin;
    private String puk;
    private String antivirus;
    private String sistemaOperativo;
}