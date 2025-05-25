package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.PersonaDTO;
import com.SistemasIcvc.Inventario_Backend.entity.Persona;
import com.SistemasIcvc.Inventario_Backend.mapper.PersonaMapper;
import com.SistemasIcvc.Inventario_Backend.repository.PersonaRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final PersonaMapper personaMapper;

    @Override
    public PersonaDTO registrarPersona(PersonaDTO personaDTO) {
        Persona persona = personaMapper.toEntity(personaDTO);
        Persona guardada = personaRepository.save(persona);
        return personaMapper.toDto(guardada);
    }


    @Override
    public PersonaDTO editarPersona(String identificacion, PersonaDTO personaDTO) {
        Optional<Persona> optionalPersona = personaRepository.findByIdidentificacion(identificacion);
        if (optionalPersona.isPresent()) {
            Persona persona = personaMapper.toEntity(personaDTO);
            persona.setId(optionalPersona.get().getId());
            return personaMapper.toDto(personaRepository.save(persona));
        }
        throw new RuntimeException("Persona no encontrada con identificacion: " + identificacion);
    }

    @Override
    public PersonaDTO consultarPorIdentificacion(String identificacion) {
        Persona persona = personaRepository.findByIdidentificacion(identificacion)
                .orElseThrow(() -> new RuntimeException("Persona no encontrada con ID: " + identificacion));
        return personaMapper.toDto(persona);
    }

    @Override
    public List<PersonaDTO> listarTodos() {
        return personaRepository.findAll().stream()
                .map(personaMapper::toDto)
                .collect(Collectors.toList());
    }
}
