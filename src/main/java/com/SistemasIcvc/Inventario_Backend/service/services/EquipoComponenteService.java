package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.EquipoComponenteDTO;

public interface EquipoComponenteService {
    EquipoComponenteDTO vincularComponenteAEquipo(Integer equipoId, Integer componenteId);
}