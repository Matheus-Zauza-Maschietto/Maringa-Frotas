package com.maringa.frotas.DTO;

import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.domain.Marca;
import com.maringa.frotas.domain.Orgao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FrotaViagemDTO implements Serializable {

        private Long idFrota;
        private String placa;
        private String tipoVeiculo;
        private String dataAdquirido;
        private String idMarca;
        private String idCategoria;
        private String idOrgao;
        private List<ViagemToFrotaDTO> viagens;




}
