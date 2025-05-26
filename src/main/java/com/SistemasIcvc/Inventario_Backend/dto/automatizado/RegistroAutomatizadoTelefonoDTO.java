package com.SistemasIcvc.Inventario_Backend.dto.automatizado;

import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import com.SistemasIcvc.Inventario_Backend.dto.TelefonoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistroAutomatizadoTelefonoDTO {
    private TelefonoDTO telefono;
    private EquipoDTO equipo;
}
