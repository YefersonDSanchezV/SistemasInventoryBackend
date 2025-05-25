package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.ImpresoraDTO;

import java.util.List;

public interface ImpresoraService {
    ImpresoraDTO registrar(ImpresoraDTO dto);
    ImpresoraDTO editar(Long id, ImpresoraDTO dto);
    ImpresoraDTO consultarPorId(Long id);
    List<ImpresoraDTO> listar();
}
