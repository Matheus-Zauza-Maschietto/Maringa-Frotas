package com.maringa.frotas.service;

import com.maringa.frotas.DTO.LoginDTO;
import com.maringa.frotas.domain.Usuario;
import com.maringa.frotas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class UsuarioService {


    @Autowired
    private UsuarioRepository repository;

    public LoginDTO validarLogin(LoginDTO usuarioDTO){
        Usuario usuarioValidador = repository.findUsuarioByLoginAndSenha(usuarioDTO.getEmail(),
                usuarioDTO.getSenha());
        LoginDTO loginDTO = new LoginDTO();
        if(Objects.nonNull(usuarioValidador)) {
            loginDTO.setEmail(Optional.ofNullable(usuarioValidador.getLogin()).orElse(null));
            loginDTO.setSenha(Optional.ofNullable(usuarioValidador.getSenha()).orElse(null));
            loginDTO.setNome(Optional.ofNullable(usuarioValidador.getNome()).orElse(null));
        }
        return loginDTO;
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        return repository.save(usuario);
    }
}
