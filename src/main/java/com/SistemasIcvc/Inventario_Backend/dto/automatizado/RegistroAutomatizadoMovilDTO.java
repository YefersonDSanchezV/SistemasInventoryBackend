package com.SistemasIcvc.Inventario_Backend.dto.automatizado;

import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import com.SistemasIcvc.Inventario_Backend.dto.MovilDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroAutomatizadoMovilDTO {
    private MovilDTO movil;
    private EquipoDTO equipo;
}
