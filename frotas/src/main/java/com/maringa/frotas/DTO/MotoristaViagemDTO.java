package com.maringa.frotas.DTO;

import com.maringa.frotas.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MotoristaViagemDTO implements Serializable {

        private Long id;
        private Long cnh;
        private Pessoa pessoa;

        private List<ViagemToPessoaDTO> viagens;




}
