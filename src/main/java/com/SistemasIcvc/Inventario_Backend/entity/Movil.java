package com.SistemasIcvc.Inventario_Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "moviles")
public class Movil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(optional = false)
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @Column(name = "celular")
    private String celular;

    @Column(name = "imei1")
    private String imei1;

    @Column(name = "imei2")
    private String imei2;

    @Column(name = "sim_card")
    private String simCard;

    @Column(name = "pin")
    private String pin;

    @Column(name = "puk")
    private String puk;

    @Column(name = "antivirus")
    private String antivirus;

    @Column(name = "sistemaoperativo")
    private String sistemaOperativo;
}

