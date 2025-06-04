package com.SistemasIcvc.Inventario_Backend.service.services.updateServiceAutomatice;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoCamarasDTO;

public interface ActualizacionAutomatizadaCamara {
    void actualizarCamaraConEquipo(Long idEquipo, RegistroAutomatizadoCamarasDTO dto);
}
