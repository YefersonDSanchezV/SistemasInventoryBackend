package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.AsignacionDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.AsignacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignacion")
@RequiredArgsConstructor
public class AsignacionController {
    private final AsignacionService asignacionService;

    // Registrar asignación
    @PostMapping("/registrar")
    public ResponseEntity<AsignacionDTO> registrar(@RequestBody AsignacionDTO dto) {
        AsignacionDTO nueva = asignacionService.registrarAsignacion(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    // Consultar todas las asignaciones
    @GetMapping("/consultar")
    public ResponseEntity<List<AsignacionDTO>> consultar() {
        return ResponseEntity.ok(asignacionService.consultarAsignaciones());
    }

    // Editar asignación por nombrePersona
    @PutMapping("/editar/{nombrePersona}")
    public ResponseEntity<AsignacionDTO> editar(@PathVariable String nombrePersona,
                                                @RequestBody AsignacionDTO dto) {
        return ResponseEntity.ok(asignacionService.editarAsignacion(nombrePersona, dto));
    }

    @GetMapping("/consulta_Completa")
    public ResponseEntity<List<AsignacionDTO>> consultarAsignaciones() {
        return ResponseEntity.ok(asignacionService.obtenerAsignacionCompleta());
    }

}
