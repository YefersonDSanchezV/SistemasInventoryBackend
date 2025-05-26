package com.SistemasIcvc.Inventario_Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "computadoras")
public class Computadora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @Column(name = "licencia_windows")
    private String licenciaWindows;

    @Column(name = "licencia_office")
    private String licenciaOffice;

    @Column(name = "procesador")
    private String procesador;

    @Column(name = "tipo_disco")
    private String tipoDisco;

    @Column(name = "capacidad_disco")
    private String capacidadDisco;

    @Column(name = "memoria_ram")
    private String memoriaRam;

    @Column(name = "antivirus")
    private String antivirus;

    @Column(name = "sistema_operativo")
    private String sistemaOperativo;
}

