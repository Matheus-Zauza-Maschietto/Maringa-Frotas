package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Abastecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idabastecimento")
    private Long idAbastecimento;
    @Column(name = "litrosabast")
    private Double litrosAbastecidos;

    @Column(name = "valorlitro")
    private Double valorLitro;
    @Column(name = "tipocombustivel")
    private Long tipoCombustivel;

    @Column(name = "dataabastecimento")
    private Date dataAbastecimento;

    @Transient
    private Double valorTotal;

    @ManyToOne
    @JoinColumn(name = "idfrota", referencedColumnName = "idfrota")
    private Frota idFrota;

    @ManyToOne
    @JoinColumn(name = "idposto", referencedColumnName = "idposto")
    private Posto idPosto;

}
