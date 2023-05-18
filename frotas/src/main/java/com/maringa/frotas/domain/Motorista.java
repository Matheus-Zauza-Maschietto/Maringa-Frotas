package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Motorista {

    @Id
    @Column(name = "idpessoa")
    private Long motorista;

    private Long cnh;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;



}
