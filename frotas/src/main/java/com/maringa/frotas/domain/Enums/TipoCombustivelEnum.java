package com.maringa.frotas.domain.Enums;

public enum TipoCombustivelEnum {

    GASOLINA(0L, "Gasolina"),
    ALCOOL(1L, "Álcool"),
    FLEX(2L, "Flex"),
    DISEL(3L, "Disel"),
    ELETRICO(4L, "Elétrico"),
    GAS_NATURAL(5L, "Gás Natural");

    private Long tipo;
    private String descricao;

    public Long getTipo(){return this.tipo;}
    public String getDescricao(){return this.descricao;}

    private TipoCombustivelEnum(Long tipo, String descricao){
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public static TipoCombustivelEnum fromCodigo(Long codigo){
        for(TipoCombustivelEnum tipoVeiculo : values()){
            if(tipoVeiculo.getTipo().equals(codigo)){
                return tipoVeiculo;
            }
        }
        return null;
    }

}
