package com.maringa.frotas.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InsertPessoaDTO {

    private String nome;
    private String cpf;
    private String email;
    private Long telefone;
    private Long idOrgao;
    private Long idCargo;


}
