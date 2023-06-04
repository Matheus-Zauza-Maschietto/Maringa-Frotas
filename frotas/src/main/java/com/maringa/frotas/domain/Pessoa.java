package com.maringa.frotas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.maringa.frotas.controller.MotoristaController;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idpessoa")
    private Long idPessoa;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    @ManyToOne
    @JoinColumn(name = "idorgao", referencedColumnName = "idOrgao")
    private Orgao idOrgao;

    @ManyToOne
    @JoinColumn(name = "idcargo", referencedColumnName = "idCargo")
    private Cargo idCargo;


    @JsonIgnore
    @OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Motorista motorista;

    @Transient
    private Boolean deletado;
}
