package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.CamaraDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.CamaraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/camaras")
@RequiredArgsConstructor
public class CamaraController {

    private final CamaraService camaraService;

    @PostMapping
    public ResponseEntity<CamaraDTO> registrarCamara(@RequestBody CamaraDTO dto) {
        CamaraDTO camaraRegistrada = camaraService.registrar(dto);
        return ResponseEntity.ok(camaraRegistrada);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CamaraDTO> editarCamara(@PathVariable Long id, @RequestBody CamaraDTO dto) {
        CamaraDTO camaraEditada = camaraService.editar(id, dto);
        return ResponseEntity.ok(camaraEditada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CamaraDTO> obtenerCamaraPorId(@PathVariable Long id) {
        CamaraDTO camara = camaraService.consultarPorId(id);
        return ResponseEntity.ok(camara);
    }

    @GetMapping
    public ResponseEntity<List<CamaraDTO>> listarCamaras() {
        List<CamaraDTO> camaras = camaraService.listar();
        return ResponseEntity.ok(camaras);
    }
}
