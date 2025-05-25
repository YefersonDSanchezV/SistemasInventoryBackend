package com.SistemasIcvc.Inventario_Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "inventario")
public class Inventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "persona_id")
    private String personaId;

    @Column(name = "nombre_persona", nullable = false)
    private String nombrePersona;

    @Column(name = "celular_persona")
    private String celularPersona;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "piso")
    private String piso;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "placa_activo_fijo", nullable = false, unique = true)
    private String placaActivoFijo;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;

    @Column(name = "usuario_id")
    private Integer usuarioId;
}

