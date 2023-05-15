package com.maringa.frotas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FrotaAllDTO implements Serializable {

    private String placa;
    private String cor;
    private String chassi;
    private String renavam;
    private String anoDeFabricacao;
    private Long nEixos;
    private String dataAdquirido;
    private Long tipoCombustivel;
    private Long tanqueTotal;
    private Long kmRodado;
    private Boolean statusFrota;
    private Boolean leilao;
    private String idMarca;
    private String idCategoria;
    private String idOrgao;


}
