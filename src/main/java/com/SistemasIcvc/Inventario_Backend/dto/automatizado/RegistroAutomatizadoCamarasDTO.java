package com.SistemasIcvc.Inventario_Backend.dto.automatizado;

import com.SistemasIcvc.Inventario_Backend.dto.CamaraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroAutomatizadoCamarasDTO {
    private EquipoDTO equipo;
    private CamaraDTO camara;
}
