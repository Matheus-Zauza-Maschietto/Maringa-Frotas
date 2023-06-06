package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.Insert.FuncionarioInsertDTO;
import com.maringa.frotas.DTO.Insert.LoginInsertDTO;
import com.maringa.frotas.DTO.LoginDTO;
import com.maringa.frotas.domain.Pessoa;
import com.maringa.frotas.domain.Usuario;
import com.maringa.frotas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Objects;

@CrossOrigin
@RestController
@RequestMapping("")
public class UsuarioController {

    @Autowired
    private UsuarioService service;


    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<LoginDTO>  loginUsuario(@RequestBody LoginDTO login){
        LoginDTO validarCadastro = service.validarLogin(login);

        if(Objects.nonNull(validarCadastro.getEmail()) && Objects.nonNull(validarCadastro.getSenha())){
            return ResponseEntity.ok(validarCadastro);
        }

        return ResponseEntity.badRequest().build();
    }

    @CrossOrigin
    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody LoginInsertDTO loginDTO){
        Usuario usuario = new Usuario();

        usuario.setNome(loginDTO.getNome());
        usuario.setLogin(loginDTO.getEmail());
        usuario.setSenha(loginDTO.getSenha());
        usuario.setConfirmarSenha(loginDTO.getConfirmarSenha());
        usuario.setCpf(loginDTO.getCpf());
        usuario.setTelefone(loginDTO.getTelefone());

        Usuario salvo = service.cadastrarUsuario(usuario);
        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
        var uri = builder.path("/{id}").buildAndExpand(salvo.getIdLogin()).toUri();
        return ResponseEntity.created(uri).body(salvo);
    }
}
