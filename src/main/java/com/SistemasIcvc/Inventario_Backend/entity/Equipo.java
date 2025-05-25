package com.SistemasIcvc.Inventario_Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "equipos")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_equipo", nullable = false)
    private String tipoEquipo;

    @Column(name = "estado", nullable = false)
    private String estado;

    @Column(name = "ubicacion")
    private String ubicacion;

    @Column(name = "placa_af")
    private String placaAf;

    @Column(name = "ip")
    private String ip;

    @Column(name = "nombremaquina")
    private String nombreMaquina;

    @Column(name = "directorioadm")
    private String directorioAdm;

    @Column(name = "vidautil")
    private String vidaUtil;

    @Column(name = "mac")
    private String mac;

    @Column(name = "numero_orden_compra")
    private String numeroOrdenCompra;

    @Column(name = "fecha_compra")
    private Integer fechaCompra;

    @Column(name = "usuario_registra")
    private Integer usuarioRegistra;

    @Column(name = "fecha_registro", nullable = false)
    private LocalDateTime fechaRegistro;
}

