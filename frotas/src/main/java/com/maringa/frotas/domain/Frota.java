package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Frota implements Serializable {

    @Id
    @Column(name = "idfrota")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFrota;


    private String placa;
    private String cor;
    private String chassi;
    private String renavam;
    private Date ano_fab;
    @Column(name = "neixos")
    private Long nEixos;
    @Column(name = "dataadquirido")
    private Date dataAdquirido;
    @Column(name = "tipocombustivel")
    private Long tipoCombustivel;
    @Column(name = "tanquetotal")
    private Long tanqueTotal;
    @Column(name = "kmrodado")
    private Long kmRodado;
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

}
