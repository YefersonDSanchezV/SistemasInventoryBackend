package com.SistemasIcvc.Inventario_Backend.service.services.updateServiceAutomatice;

import com.SistemasIcvc.Inventario_Backend.dto.actualizacionesAutomatizadas.ActualizacionAutomaticaComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoCamarasDTO;

public interface ActualizacionAutomatizadaComputadora {
    void actualizarComputadoraConComponentes(Long idEquipo, ActualizacionAutomaticaComputadoraDTO actualizacionAutomaticaComputadoraDTO);

    void actualizarCamaraConEquipo(Long idEquipo, RegistroAutomatizadoCamarasDTO dto);
}
