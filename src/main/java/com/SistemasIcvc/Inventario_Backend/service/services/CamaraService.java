package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.CamaraDTO;

import java.util.List;

public interface CamaraService {
    CamaraDTO registrar(CamaraDTO dto);
    CamaraDTO editar(Long id, CamaraDTO dto);
    CamaraDTO consultarPorId(Long id);
    List<CamaraDTO> listar();
}
