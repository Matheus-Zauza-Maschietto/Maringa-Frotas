package com.maringa.frotas.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idcategoria")
    private Long idCategoria;

    @Column(name = "tipocategoria")
    private String tipoCategoria;

    @ManyToOne
    @JoinColumn(name = "idmarca", referencedColumnName = "idMarca")
    private Marca idMarca;

}
