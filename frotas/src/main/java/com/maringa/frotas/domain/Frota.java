package com.maringa.frotas.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
public class Frota  {

    @Id
    @Column(name = "idfrota")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFrota;


    private String placa;
    private String cor;
    private String chassi;
    private String renavam;
    @Column(name = "anofabricacao")
    private Integer anoFabricacao;
    @Column(name = "tipoveiculo")
    private Long tipoVeiculo;
    @Column(name = "neixos")
    private String nEixos;
    @Column(name = "dataadquirido")
    private Date dataAdquirido;
    @Column(name = "tipocombustivel")
    private Long tipoCombustivel;
    @Column(name = "tanquetotal")
    private String tanqueTotal;
    @Column(name = "kmrodado")
    private String kmRodado;
    @Column(name = "statusfrota")
    private Boolean statusFrota;
    private Boolean leilao;
    @ManyToOne
    @JoinColumn(name = "idmarca", referencedColumnName = "idMarca")
    private Marca idMarca;
    @ManyToOne
    @JoinColumn(name = "idcategoria", referencedColumnName = "idCategoria")
    private Categoria idCategoria;
    @ManyToOne
    @JoinColumn(name = "idorgao", referencedColumnName = "idOrgao")
    private Orgao idOrgao;

    @Transient
    private Boolean deletado;
}
