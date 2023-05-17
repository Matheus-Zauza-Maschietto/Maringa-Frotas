package com.maringa.frotas.domain.Enums;

public enum TipoVeiculoEnum {

    CARRO(0L, "Carro"),
    MOTO(1L, "Moto"),
    CAMINHAO(2L, "Caminhão"),
    ONIBUS(3L, "Ônibus"),
    FURGAO(4L, "Furgão");

    private Long tipo;
    private String descricao;

    public Long getTipo(){return this.tipo;}
    public String getDescricao(){return this.descricao;}

    private TipoVeiculoEnum(Long tipo, String descricao){
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public static TipoVeiculoEnum fromCodigo(Long codigo){
        for(TipoVeiculoEnum tipoVeiculo : values()){
            if(tipoVeiculo.getTipo().equals(codigo)){
                return tipoVeiculo;
            }
        }
        return null;
    }

}
