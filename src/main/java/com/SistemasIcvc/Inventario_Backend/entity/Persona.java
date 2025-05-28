package com.SistemasIcvc.Inventario_Backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tipo_identificacion", nullable = false)
    private String tipoIdentificacion;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @Column(name = "correo_institucional", nullable = false)
    private String correoInstitucional;

    @Column(name = "correo_gmail", nullable = false)
    private String correoGmail;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    @Column(name = "ididentificacion", nullable = false, unique = true)
    private String ididentificacion;
}

