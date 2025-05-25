package com.SistemasIcvc.Inventario_Backend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
    private Long id;
    private String tipoIdentificacion;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String correoInstitucional;
    private String correoGmail;
    private String telefono;
    private String ididentificacion;
}
