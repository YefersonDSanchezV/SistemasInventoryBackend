package com.SistemasIcvc.Inventario_Backend.service.services;

import com.SistemasIcvc.Inventario_Backend.dto.PersonaDTO;

import java.util.List;

public interface PersonaService {
    PersonaDTO registrarPersona(PersonaDTO personaDTO);
    PersonaDTO editarPersona(String ididentificacion, PersonaDTO personaDTO);
    PersonaDTO consultarPorIdentificacion(String ididentificacion);
    List<PersonaDTO> listarTodos();
}
