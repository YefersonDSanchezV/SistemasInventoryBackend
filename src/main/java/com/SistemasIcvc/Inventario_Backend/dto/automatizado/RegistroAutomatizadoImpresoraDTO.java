package com.SistemasIcvc.Inventario_Backend.dto.automatizado;

import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import com.SistemasIcvc.Inventario_Backend.dto.ImpresoraDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroAutomatizadoImpresoraDTO {
    private EquipoDTO equipo;
    private ImpresoraDTO impresora;
}
