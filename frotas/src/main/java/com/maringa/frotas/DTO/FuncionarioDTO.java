package com.maringa.frotas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioDTO implements Serializable {

    private Long id;
    private String nome;
    private String cpf;
    private String cnh;
    private String orgao;
    private String cargo;

}
