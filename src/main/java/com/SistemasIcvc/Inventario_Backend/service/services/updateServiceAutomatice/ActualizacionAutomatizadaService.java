package com.SistemasIcvc.Inventario_Backend.service.services.updateServiceAutomatice;

import com.SistemasIcvc.Inventario_Backend.dto.actualizacionesAutomatizadas.ActualizacionAutomaticaComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoCamarasDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoImpresoraDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoMovilDTO;
import com.SistemasIcvc.Inventario_Backend.dto.automatizado.RegistroAutomatizadoTelefonoDTO;

public interface ActualizacionAutomatizadaService {
    void actualizarComputadoraConComponentes(Long idEquipo, ActualizacionAutomaticaComputadoraDTO actualizacionAutomaticaComputadoraDTO);
    void actualizarCamaraConEquipo(Long idEquipo, RegistroAutomatizadoCamarasDTO dto);
    void actualizarMovilConEquipo(Long idEquipo, RegistroAutomatizadoMovilDTO dto);
    void actualizarImpresoraConEquipo(Long idEquipo, RegistroAutomatizadoImpresoraDTO dto);
    void actualizarTelefonoConEquipo(Long idEquipo, RegistroAutomatizadoTelefonoDTO dto);
}
