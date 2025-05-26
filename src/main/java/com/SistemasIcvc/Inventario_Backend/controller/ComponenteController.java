package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.ComponenteDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.ComponenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/componentes")
@RequiredArgsConstructor
public class ComponenteController {

    private final ComponenteService componenteService;

    @PostMapping
    public ResponseEntity<ComponenteDTO> registrarComponente(@RequestBody ComponenteDTO dto) {
        return ResponseEntity.ok(componenteService.registrar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComponenteDTO> editarComponente(@PathVariable Long id, @RequestBody ComponenteDTO dto) {
        return ResponseEntity.ok(componenteService.editar(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComponenteDTO> consultarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(componenteService.consultarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ComponenteDTO>> listarTodos() {
        return ResponseEntity.ok(componenteService.listarTodos());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ComponenteDTO>> listarPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(componenteService.listarPorTipo(tipo));
    }
}

