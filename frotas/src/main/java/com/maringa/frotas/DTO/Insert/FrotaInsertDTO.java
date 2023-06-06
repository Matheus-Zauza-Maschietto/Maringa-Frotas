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

    private Long veiculo;
    private Long marca;
    private String chassi;
    private Long modelo;
    private String placa;
    private String renavam;
    private Long combustivel;
    private String numeroEixos;
    private Integer anoModelo;
    private Date dataAquisicao;
    private String quilometrosRodados;
    private String capacidadeTanque;
    private Long orgao;
    private String cor;



}
