package com.maringa.frotas.DTO.Insert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class FrotaInsertDTO {

    private String placa;
    private String cor;
    private String chassi;
    private String renavam;
    private Date dataAquisicao;
    private Integer anoFabricacao;
    private Long idMarca;
    private Long idModelo;
    private String capacidadeTanque;
    private String quilometrosRodados;
    private String numeroEixos;



}
