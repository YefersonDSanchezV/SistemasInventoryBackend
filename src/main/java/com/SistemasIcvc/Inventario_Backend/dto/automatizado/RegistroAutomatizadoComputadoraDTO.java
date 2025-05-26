package com.SistemasIcvc.Inventario_Backend.dto.automatizado;

import com.SistemasIcvc.Inventario_Backend.dto.ComponenteDTO;
import com.SistemasIcvc.Inventario_Backend.dto.ComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroAutomatizadoComputadoraDTO {
    private EquipoDTO equipo;
    private ComputadoraDTO computadora;
    private List<ComponenteDTO> componentes;

}


