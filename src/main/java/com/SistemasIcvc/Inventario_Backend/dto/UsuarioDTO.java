package com.SistemasIcvc.Inventario_Backend.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private Integer id;
    private String personaId;
    private String nombreUsuario;
    private String contrasena;
    private Boolean estado;
    private LocalDateTime fechaCreacion;
}