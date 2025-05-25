package com.SistemasIcvc.Inventario_Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Entity
@Data
@NoArgsConstructor
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "fecha", nullable = false)
    private Timestamp fecha;

    @Column(name = "accion", nullable = false)
    private String accion;

    @Column(name = "detalles")
    private String detalles;

    @Column(name = "equipo_id")
    private Integer equipoId;
}

