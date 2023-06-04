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
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idmarca")
    private Long idMarca;

    @Column(name = "tipomarca")
    private String tipoMarca;
}
