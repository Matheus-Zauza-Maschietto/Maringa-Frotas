package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "empresarevisao")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpresaRevisao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idemprevisao")
    private Long idEmpRevisao;

    @Column(name = "nomeempresa")
    private String nomeEmpresa;

    @Column(name = "cepempresa")
    private String cepEmpresa;

    @Column(name = "cnpjempresa")
    private String cnpjEmpresa;

    @Column(name = "telefoneempresa")
    private String telefoneEmpresa;

    @Transient
    private boolean deletado;
}
