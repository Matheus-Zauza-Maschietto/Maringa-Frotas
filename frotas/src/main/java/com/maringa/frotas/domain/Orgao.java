package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orgao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idorgao")
    private Long idOrgao;

    @Column(name = "nomeorgao")
    private String nomeOrgao;
}
