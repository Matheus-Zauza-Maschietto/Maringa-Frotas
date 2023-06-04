package com.maringa.frotas.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.maringa.frotas.domain.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    public String gerarToken(Usuario usuario) {
        return JWT.create()
                .withSubject(usuario.getUsername())
                .withClaim("id", usuario.getIdLogin())
                .withExpiresAt(LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("secreta"));
    }
}
