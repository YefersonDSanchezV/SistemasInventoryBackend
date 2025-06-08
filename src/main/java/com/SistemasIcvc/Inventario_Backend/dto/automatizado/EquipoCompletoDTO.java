package com.SistemasIcvc.Inventario_Backend.dto.automatizado;

import com.SistemasIcvc.Inventario_Backend.entity.*;
import lombok.Data;

import java.util.List;

@Data
public class EquipoCompletoDTO {
    private Equipo equipo;

    private Computadora computadora;
    private List<Componente> componentes;

    private Camara camara;
    private Impresora impresora;
    private Movil movil;
    private Telefono telefono;
}
