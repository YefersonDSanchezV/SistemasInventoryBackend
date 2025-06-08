package com.SistemasIcvc.Inventario_Backend.service.implement;

import com.SistemasIcvc.Inventario_Backend.dto.automatizado.UsuariosCompletosDTO;
import com.SistemasIcvc.Inventario_Backend.repository.UsuarioRepository;
import com.SistemasIcvc.Inventario_Backend.service.services.UsuarioConsultarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioConsultaServiceImpl implements UsuarioConsultarService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public List<UsuariosCompletosDTO> obtenerUsuariosCompletos() {
        return usuarioRepository.consultarUsuarioCompleto();
    }
}
