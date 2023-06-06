package com.maringa.frotas.DTO.Insert;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginInsertDTO implements Serializable {
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private String senha;
    private String confirmarSenha;
}
