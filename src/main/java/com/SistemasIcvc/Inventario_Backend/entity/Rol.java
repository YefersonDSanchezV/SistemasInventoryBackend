package com.SistemasIcvc.Inventario_Backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "nombre_rol", nullable = false, unique = true)
    private String nombreRol;

    @OneToMany(mappedBy = "rol", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<RolesUsuarios> rolesUsuarios;
}

