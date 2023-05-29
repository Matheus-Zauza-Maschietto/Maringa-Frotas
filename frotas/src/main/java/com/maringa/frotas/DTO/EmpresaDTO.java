package com.maringa.frotas.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpresaDTO implements Serializable {

    private Long id;
    private String nome;
    private String cnpj;
    private String cep;
    private String telefone;

}
