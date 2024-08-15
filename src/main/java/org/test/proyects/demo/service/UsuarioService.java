package org.test.proyects.demo.service;

import org.test.proyects.demo.model.dto.UsuarioDTO;

import java.util.Optional;

public interface UsuarioService {

    void createUsuario(UsuarioDTO usuarioDTO);

    Optional<UsuarioDTO> getUsuarioById(Long id);

}
