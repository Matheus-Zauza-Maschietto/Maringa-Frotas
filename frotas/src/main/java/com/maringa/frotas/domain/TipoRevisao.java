package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tiporevisao")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoRevisao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idtiporevisao")
    private Long idTipoRevisao;

    @Column(name = "descricaorevisao")
    private String descricaoRevisao;

}