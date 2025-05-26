package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.MovilDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.MovilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movil")
public class MovilController {

    private final MovilService movilService;

    @PostMapping
    public ResponseEntity<MovilDTO> registrarMovil(@RequestBody MovilDTO dto) {
        MovilDTO movilRegistrado = movilService.registrar(dto);
        return ResponseEntity.ok(movilRegistrado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovilDTO> editarMovil(@PathVariable Long id, @RequestBody MovilDTO dto) {
        MovilDTO movilEditado = movilService.editar(id, dto);
        return ResponseEntity.ok(movilEditado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovilDTO> obtenerMovilPorId(@PathVariable Long id) {
        MovilDTO movil = movilService.consultarPorId(id);
        return ResponseEntity.ok(movil);
    }

    @GetMapping
    public ResponseEntity<List<MovilDTO>> listarMoviles() {
        List<MovilDTO> moviles = movilService.listar();
        return ResponseEntity.ok(moviles);
    }
}
