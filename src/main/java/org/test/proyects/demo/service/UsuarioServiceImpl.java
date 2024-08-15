package org.test.proyects.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.proyects.demo.model.dto.UsuarioDTO;
import org.test.proyects.demo.model.entity.Usuario;
import org.test.proyects.demo.repositry.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void createUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario();
        usuario.setUserId(usuarioDTO.getUserId());
        usuario.setNickname(usuarioDTO.getNickname());
        usuario.setUsuario(usuarioDTO.getUsuario());
        usuario.setPassword(usuarioDTO.getPassword());
        usuarioRepository.save(usuario);
    }

    @Override
    public Optional<UsuarioDTO> getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    UsuarioDTO dto = new UsuarioDTO();
                    dto.setUserId(usuario.getUserId());
                    dto.setNickname(usuario.getNickname());
                    dto.setUsuario(usuario.getUsuario());
                    dto.setPassword(usuario.getPassword());
                    return dto;
                });
    }

}
