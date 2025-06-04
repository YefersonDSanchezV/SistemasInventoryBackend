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

    @ManyToOne
    @JoinColumn(name = "equipo_id", insertable = false, updatable = false)
    private Equipo equipo;

    @Column(name = "nvr_relacionado")
    private String nvrRelacionado;

    @Column(name = "nombre_camara")
    private String nombreCamara;

    @Column(name = "poe")
    private String poe;
}

