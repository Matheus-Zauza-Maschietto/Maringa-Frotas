package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idposto")
    private Long idPosto;

    @Column(name = "nomeposto")
    private String nomePosto;
}
