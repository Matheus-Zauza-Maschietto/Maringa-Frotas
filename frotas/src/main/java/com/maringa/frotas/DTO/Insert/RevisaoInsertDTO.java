package com.maringa.frotas.DTO.Insert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RevisaoInsertDTO implements Serializable {

    private Long id;
    private Date dataRevisao;
    private Double valor;
    private String descricao;
    private Long tipoManutencao;
    private Long idEmpresa;
    private String placa;
}
