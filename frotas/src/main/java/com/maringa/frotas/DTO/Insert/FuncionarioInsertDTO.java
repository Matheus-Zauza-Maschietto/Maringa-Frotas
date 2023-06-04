package com.maringa.frotas.DTO.Insert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FuncionarioInsertDTO {

    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Long idCargo;
    private Long idOrgao;
}
