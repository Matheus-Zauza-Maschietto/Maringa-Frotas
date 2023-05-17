package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Double litrosAbastecimento;

    @Column(name = "valorlitro")
    private Double valorLitro;
    @Column(name = "tipocombustivel")
    private Long tipoCombustivel;

    @Column(name= "idfrota")
    private Long idFrota;

    @Column(name= "idposto")
    private Long idPosto;

}
