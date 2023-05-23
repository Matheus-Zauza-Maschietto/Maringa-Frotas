package com.maringa.frotas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MotoristaDTO implements Serializable {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private Integer telefone;
    private Integer cnh;
    private String orgao;
    private String cargo;

}
