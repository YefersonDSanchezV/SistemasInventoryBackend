package com.SistemasIcvc.Inventario_Backend.controller;

import com.SistemasIcvc.Inventario_Backend.dto.PersonaDTO;
import com.SistemasIcvc.Inventario_Backend.service.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    public ResponseEntity<PersonaDTO> registrarPersona(@RequestBody PersonaDTO personaDTO) {
        PersonaDTO personaRegistrada = personaService.registrarPersona(personaDTO);
        return ResponseEntity.ok(personaRegistrada);
    }

    @PutMapping("/{identificacion}")
    public ResponseEntity<PersonaDTO> editarPersona(@PathVariable String identificacion,
                                                    @RequestBody PersonaDTO personaDTO) {
        PersonaDTO personaEditada = personaService.editarPersona(identificacion, personaDTO);
        return ResponseEntity.ok(personaEditada);
    }

    @GetMapping("/{identificacion}")
    public ResponseEntity<PersonaDTO> consultarPorIdentificacion(@PathVariable String identificacion) {
        PersonaDTO persona = personaService.consultarPorIdentificacion(identificacion);
        return ResponseEntity.ok(persona);
    }

    @GetMapping
    public ResponseEntity<List<PersonaDTO>> listarTodos() {
        List<PersonaDTO> personas = personaService.listarTodos();
        return ResponseEntity.ok(personas);
    }
}
