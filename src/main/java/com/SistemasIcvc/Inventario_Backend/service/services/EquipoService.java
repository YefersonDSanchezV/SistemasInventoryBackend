package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Equipo;

import java.util.List;
import java.util.Optional;

public interface EquipoService {
    EquipoDTO registrarEquipo(EquipoDTO equipoDTO);
    EquipoDTO editarEquipoPorId(Long id, EquipoDTO equipoDTO);
    EquipoDTO editarEquipoPorEstado(String estado, EquipoDTO equipoDTO);
    EquipoDTO editarEquipoPorNombre(String nombre, EquipoDTO equipoDTO);
    EquipoDTO consultarPorId(Long id);
    EquipoDTO consultarPorNombre(String nombre);
    List<EquipoDTO> consultarPorFechaRegistro(String fecha); // considerar usar LocalDate
    List<EquipoDTO> consultarPorEstado(String estado);
    List<EquipoDTO> listarTodos();
}
