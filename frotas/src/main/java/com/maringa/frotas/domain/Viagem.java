package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "viagens")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idviagem")
    private Long idViagem;

    @Column(name = "saidafrota")
    private Date saidaFrota;

    @Column(name = "entradafrota")
    private Date entradaFrota;

    @Column(name = "kilometragemviagem")
    private Double kilometragemViagem;

    @ManyToOne
    @JoinColumn(name = "iduso", referencedColumnName = "iduso")
    private Uso idUso;

    @ManyToOne
    @JoinColumn(name = "idpessoa", referencedColumnName = "idpessoa")
    private Motorista idMotorista;

    @ManyToOne
    @JoinColumn(name = "idfrota", referencedColumnName = "idfrota")
    private Frota idVeiculo;
}
