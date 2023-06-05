package com.maringa.frotas.DTO.Insert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmpresaInsertDTO {

    private String nomeEmpresa;
    private String cnpjEmpresa;
    private String telefoneEmpresa;
    private String cepEmpresa;
}
