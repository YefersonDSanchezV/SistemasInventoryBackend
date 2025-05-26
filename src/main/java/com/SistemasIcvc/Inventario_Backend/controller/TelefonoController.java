package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.TelefonoDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.TelefonoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/telefonos")
@RequiredArgsConstructor
public class TelefonoController {

    private final TelefonoService telefonoService;

    // Registrar un nuevo teléfono
    @PostMapping
    public ResponseEntity<TelefonoDTO> registrarTelefono(@RequestBody TelefonoDTO telefonoDTO) {
        TelefonoDTO registrado = telefonoService.registrar(telefonoDTO);
        return ResponseEntity.ok(registrado);
    }

    // Editar teléfono por ID
    @PutMapping("/{id}")
    public ResponseEntity<TelefonoDTO> editarTelefono(@PathVariable Long id, @RequestBody TelefonoDTO telefonoDTO) {
        TelefonoDTO actualizado = telefonoService.editar(id, telefonoDTO);
        return ResponseEntity.ok(actualizado);
    }

    // Consultar un teléfono por ID
    @GetMapping("/{id}")
    public ResponseEntity<TelefonoDTO> consultarPorId(@PathVariable Long id) {
        TelefonoDTO dto = telefonoService.consultarPorId(id);
        return ResponseEntity.ok(dto);
    }

    // Listar todos los teléfonos
    @GetMapping
    public ResponseEntity<List<TelefonoDTO>> listarTodos() {
        return ResponseEntity.ok(telefonoService.listar());
    }
}
