package com.SistemasIcvc.Inventario_Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "camaras")
public class Camara {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "equipo_id")
    private Integer equipoId;

    @Column(name = "nvr_relacionado")
    private String nvrRelacionado;

    @Column(name = "nombre_camara")
    private String nombreCamara;

    @Column(name = "poe")
    private String poe;
}

