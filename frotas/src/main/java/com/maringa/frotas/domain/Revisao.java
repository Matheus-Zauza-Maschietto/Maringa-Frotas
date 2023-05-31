package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "revisoes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Revisao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idrevisao")
    private Long idRevisao;

    @Column(name = "datarevisao")
    private Date dataRevisao;

    private Double custo;

    @Column(name = "descricaorevi")
    private String descricaoRevi;

    @ManyToOne
    @JoinColumn(name = "idfrota", referencedColumnName = "idFrota")
    private Frota idFrota;

    @ManyToOne
    @JoinColumn(name = "idemprevisao", referencedColumnName = "idEmpRevisao")
    private EmpresaRevisao idEmpRevisao;

    @ManyToOne
    @JoinColumn(name = "idtiporevisao", referencedColumnName = "idTipoRevisao")
    private TipoRevisao idTipoRevisao;

}
