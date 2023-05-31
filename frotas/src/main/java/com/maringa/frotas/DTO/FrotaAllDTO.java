package com.maringa.frotas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FrotaAllDTO implements Serializable {

    private Long id;
    private String placa;
    private String tipoVeiculo;
    private String idCategoria;
    private String idMarca;
    private String tipoCombustivel;
    private String kmRodado;
    private String idOrgao;
    private String dataAdquirido;
    private Boolean statusFrota;
    private Boolean leilao;


}
