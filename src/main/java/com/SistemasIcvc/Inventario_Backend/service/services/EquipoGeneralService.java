package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.EquipoCompletoDTO;

import java.util.List;

public interface EquipoGeneralService {

    public List<EquipoCompletoDTO> obtenerTodosLosEquiposCompletos();
}
