package com.maringa.frotas.service;

import com.maringa.frotas.DTO.FrotaAllDTO;
import com.maringa.frotas.Utils.DateUtils;
import com.maringa.frotas.domain.Enums.TipoCombustivelEnum;
import com.maringa.frotas.domain.Enums.TipoVeiculoEnum;
import com.maringa.frotas.domain.Frota;
import com.maringa.frotas.repository.FrotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrotaService {

    @Autowired
    private FrotaRepository repository;

    public static List<FrotaAllDTO> listToListDTO(List<Frota> listFrota) {
        List<FrotaAllDTO> listFrotaAllDTO = new ArrayList<>();

        for (Frota frota : listFrota) {
            FrotaAllDTO frotaAllDTO = new FrotaAllDTO();
            frotaAllDTO.setPlaca(frota.getPlaca());
            frotaAllDTO.setCor(frota.getCor());
            frotaAllDTO.setChassi(frota.getChassi());
            frotaAllDTO.setRenavam(frota.getRenavam());
            frotaAllDTO.setAnoDeFabricacao(DateUtils.DateToString(frota.getAnoFabricacao()));
            frotaAllDTO.setDataAdquirido(DateUtils.DateToString(frota.getDataAdquirido()));
            frotaAllDTO.setNEixos(frota.getNEixos());
            frotaAllDTO.setTipoVeiculo(TipoVeiculoEnum.fromCodigo(frota.getTipoVeiculo()).getDescricao());
            frotaAllDTO.setTipoCombustivel(TipoCombustivelEnum.fromCodigo(frota.getTipoCombustivel()).getDescricao());
            frotaAllDTO.setTanqueTotal(frota.getTanqueTotal());
            frotaAllDTO.setKmRodado(frota.getKmRodado());
            frotaAllDTO.setStatusFrota(frota.getStatusFrota());
            frotaAllDTO.setLeilao(frota.getLeilao());
            frotaAllDTO.setIdMarca(frota.getIdMarca().getTipoMarca());
            frotaAllDTO.setIdOrgao(frota.getIdOrgao().getNomeOrgao());
            frotaAllDTO.setIdCategoria(frota.getIdCategoria().getTipoCategoria());

            listFrotaAllDTO.add(frotaAllDTO);
        }
        return listFrotaAllDTO;
    }

    public List<FrotaAllDTO> findAllFrota() {
        List<Frota> listFrota = repository.findAll();
        return listToListDTO(listFrota);
    }

    public List<FrotaAllDTO> findVeiculosKmMaiorQueMedia(){
        List<Frota> listFrota = repository.findVeiculosKmMaiorQueMedia();
        return listToListDTO(listFrota);
    }

}



