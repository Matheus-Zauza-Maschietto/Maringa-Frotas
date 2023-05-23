package com.maringa.frotas.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Uso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "iduso")
    private Long idUso;

    @Column(name = "tipouso")
    private String tipouso;

}
