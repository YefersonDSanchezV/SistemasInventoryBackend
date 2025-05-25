package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.ComputadoraDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.ComputadoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/computadoras")
public class ComputadoraController {

    private final ComputadoraService computadoraService;

    @PostMapping
    public ResponseEntity<ComputadoraDTO> registrarComputadora(@RequestBody ComputadoraDTO computadoraDTO) {
        ComputadoraDTO nuevaComputadora = computadoraService.registrar(computadoraDTO);
        return ResponseEntity.ok(nuevaComputadora);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComputadoraDTO> editarComputadora(@PathVariable Long id, @RequestBody ComputadoraDTO computadoraDTO) {
        ComputadoraDTO computadoraEditada = computadoraService.editar(id, computadoraDTO);
        return ResponseEntity.ok(computadoraEditada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputadoraDTO> consultarPorId(@PathVariable Long id) {
        ComputadoraDTO computadoraDTO = computadoraService.consultarPorId(id);
        return ResponseEntity.ok(computadoraDTO);
    }

    @GetMapping
    public ResponseEntity<List<ComputadoraDTO>> listarComputadoras() {
        List<ComputadoraDTO> computadoras = computadoraService.listar();
        return ResponseEntity.ok(computadoras);
    }
}
