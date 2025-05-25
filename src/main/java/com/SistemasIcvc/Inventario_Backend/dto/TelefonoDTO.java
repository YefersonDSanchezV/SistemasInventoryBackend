package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefonoDTO {
    private Integer id;
    private Integer equipoId;
    private String extension;
    private String poe;
}
