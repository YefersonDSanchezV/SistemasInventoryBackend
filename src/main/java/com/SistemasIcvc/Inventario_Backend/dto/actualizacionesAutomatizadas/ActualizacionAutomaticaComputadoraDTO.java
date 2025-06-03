package com.SistemasIcvc.Inventario_Backend.dto.actualizacionesAutomatizadas;

import com.SistemasIcvc.Inventario_Backend.dto.ComponenteDTO;
import com.SistemasIcvc.Inventario_Backend.dto.ComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import lombok.Data;

import java.util.List;

@Data
public class ActualizacionAutomaticaComputadoraDTO {
    private EquipoDTO equipo;
    private ComputadoraDTO computadora;
    private List<ComponenteDTO> componentes;
}
