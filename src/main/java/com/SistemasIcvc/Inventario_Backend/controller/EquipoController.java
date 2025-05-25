package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.EquipoDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.EquipoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
public class EquipoController {

    private final EquipoService equipoService;

    @PostMapping
    public ResponseEntity<EquipoDTO> registrarEquipo(@RequestBody EquipoDTO equipoDTO) {
        EquipoDTO nuevoEquipo = equipoService.registrarEquipo(equipoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoEquipo);
    }

    @PutMapping("/editar/id/{id}")
    public ResponseEntity<EquipoDTO> editarEquipoPorId(@PathVariable Long id, @RequestBody EquipoDTO equipoDTO) {
        EquipoDTO equipoEditado = equipoService.editarEquipoPorId(id, equipoDTO);
        return ResponseEntity.ok(equipoEditado);
    }

    @PutMapping("/editar/estado/{estado}")
    public ResponseEntity<EquipoDTO> editarEquipoPorEstado(@PathVariable String estado, @RequestBody EquipoDTO equipoDTO) {
        EquipoDTO equipoEditado = equipoService.editarEquipoPorEstado(estado, equipoDTO);
        return ResponseEntity.ok(equipoEditado);
    }

    @PutMapping("/editar/nombre/{nombre}")
    public ResponseEntity<EquipoDTO> editarEquipoPorNombre(@PathVariable String nombre, @RequestBody EquipoDTO equipoDTO) {
        EquipoDTO equipoEditado = equipoService.editarEquipoPorNombre(nombre, equipoDTO);
        return ResponseEntity.ok(equipoEditado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipoDTO> consultarPorId(@PathVariable Long id) {
        EquipoDTO equipo = equipoService.consultarPorId(id);
        return ResponseEntity.ok(equipo);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<EquipoDTO>> consultarPorFechaRegistro(@PathVariable String fecha) {
        List<EquipoDTO> equipos = equipoService.consultarPorFechaRegistro(fecha);
        return ResponseEntity.ok(equipos);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<EquipoDTO>> consultarPorEstado(@PathVariable String estado) {
        List<EquipoDTO> equipos = equipoService.consultarPorEstado(estado);
        return ResponseEntity.ok(equipos);
    }

    @GetMapping
    public ResponseEntity<List<EquipoDTO>> listarTodos() {
        List<EquipoDTO> equipos = equipoService.listarTodos();
        return ResponseEntity.ok(equipos);
    }

}
