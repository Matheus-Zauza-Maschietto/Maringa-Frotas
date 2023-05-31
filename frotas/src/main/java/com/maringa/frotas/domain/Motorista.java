package com.maringa.frotas.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    private String cnh;

    @OneToOne
    @MapsId
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;
}
