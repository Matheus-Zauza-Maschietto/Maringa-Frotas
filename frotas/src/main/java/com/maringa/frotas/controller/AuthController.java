package com.maringa.frotas.controller;

import com.maringa.frotas.domain.Usuario;
import com.maringa.frotas.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public String login(@RequestBody Usuario login){

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(login.getLogin(),
                login.getSenha());

        Authentication authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        Usuario usuario = (Usuario) authentication.getPrincipal();

        return tokenService.gerarToken(usuario);
    }

}
