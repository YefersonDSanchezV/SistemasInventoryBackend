package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.ImpresoraDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.ImpresoraService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/impresora")
public class ImpresoraController {

    private final ImpresoraService impresoraService;

    @PostMapping
    public ResponseEntity<ImpresoraDTO> registrar(@RequestBody ImpresoraDTO dto) {
        return ResponseEntity.ok(impresoraService.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ImpresoraDTO> editar(@PathVariable Long id, @RequestBody ImpresoraDTO dto) {
        return ResponseEntity.ok(impresoraService.editar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImpresoraDTO> consultar(@PathVariable Long id) {
        return ResponseEntity.ok(impresoraService.consultarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ImpresoraDTO>> listar() {
        return ResponseEntity.ok(impresoraService.listar());
    }
}
