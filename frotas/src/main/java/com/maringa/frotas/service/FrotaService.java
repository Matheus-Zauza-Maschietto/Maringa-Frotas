package com.maringa.frotas.service;

import com.maringa.frotas.DTO.FrotaAllDTO;
import com.maringa.frotas.DTO.FrotaViagemDTO;
import com.maringa.frotas.DTO.ViagemToFrotaDTO;
import com.maringa.frotas.Utils.DateUtils;
import com.maringa.frotas.domain.Enums.TipoCombustivelEnum;
import com.maringa.frotas.domain.Enums.TipoVeiculoEnum;
import com.maringa.frotas.domain.Frota;
import com.maringa.frotas.domain.Viagem;
import com.maringa.frotas.repository.FrotaRepository;
import com.maringa.frotas.repository.MotoristaRepository;
import com.maringa.frotas.repository.ViagemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrotaService {

    @Autowired
    private FrotaRepository repository;
    @Autowired
    private ViagemRepository viagemRepository;
    @Autowired
    private MotoristaRepository motoristaRepository;

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

    public static FrotaAllDTO frotaToFrotaDTO(Frota frota) {

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

        return frotaAllDTO;
    }

    public List<FrotaAllDTO> findAllFrota() {
        List<Frota> listFrota = repository.findAll();
        return listToListDTO(listFrota);
    }

    public List<FrotaAllDTO> findVeiculosKmMaiorQueMedia(){
        List<Frota> listFrota = repository.findVeiculosKmMaiorQueMedia();
        return listToListDTO(listFrota);
    }

    public Frota findVeiculoByPlaca(String placa){
        return repository.findFrotaByPlaca(placa);
    }

    public Frota findVeiculoById(Long id){
        return repository.findFrotaByIdFrota(id);
    }

    public FrotaViagemDTO viagensVeiculo(Long id){

        Frota frota = repository.findFrotaByIdFrota(id);

        FrotaViagemDTO frotaViagemDTO = new FrotaViagemDTO();
        frotaViagemDTO.setIdFrota(frota.getIdFrota());
        frotaViagemDTO.setPlaca(frota.getPlaca());
        frotaViagemDTO.setDataAdquirido(DateUtils.DateToString(frota.getDataAdquirido()));
        frotaViagemDTO.setTipoVeiculo(TipoVeiculoEnum.fromCodigo(frota.getTipoVeiculo()).getDescricao());
        frotaViagemDTO.setIdMarca(frota.getIdMarca().getTipoMarca());
        frotaViagemDTO.setIdOrgao(frota.getIdOrgao().getNomeOrgao());
        frotaViagemDTO.setIdCategoria(frota.getIdCategoria().getTipoCategoria());

        List<ViagemToFrotaDTO> listDTO = new ArrayList<>();

        List<Viagem> viagens = viagemRepository.findByIdVeiculo(frota);
        for (Viagem viagem: viagens) {
            ViagemToFrotaDTO viagemDTO = new ModelMapper().map(viagem, ViagemToFrotaDTO.class);
            listDTO.add(viagemDTO);
        }

        frotaViagemDTO.setViagens(listDTO);

        return frotaViagemDTO;

    }
}



