package com.maringa.frotas.DTO;

import com.maringa.frotas.domain.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ViagemToFrotaDTO implements Serializable {

        private Long idViagem;
        private Date saidaFrota;
        private Date entradaFrota;
        private Double kilometragemViagem;
        private Uso idUso;
        private Motorista motorista;


}
