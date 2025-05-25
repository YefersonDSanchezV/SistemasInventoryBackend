package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComponenteDTO {
    private Integer id;
    private String tipo;
    private String modelo;
    private String serial;
    private String marca;
}
