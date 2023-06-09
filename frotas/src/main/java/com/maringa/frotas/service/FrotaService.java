package com.maringa.frotas.service;

import com.maringa.frotas.DTO.FrotaAllDTO;
import com.maringa.frotas.DTO.FrotaViagemDTO;
import com.maringa.frotas.DTO.Insert.FrotaInsertDTO;
import com.maringa.frotas.DTO.ViagemToFrotaDTO;
import com.maringa.frotas.Utils.DateUtils;
import com.maringa.frotas.domain.*;
import com.maringa.frotas.domain.Enums.TipoCombustivelEnum;
import com.maringa.frotas.domain.Enums.TipoVeiculoEnum;
import com.maringa.frotas.repository.*;
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
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private OrgaoRepositoy orgaoRepositoy;

    public static List<FrotaAllDTO> listToListDTO(List<Frota> listFrota) {
        List<FrotaAllDTO> listFrotaAllDTO = new ArrayList<>();

        for (Frota frota : listFrota) {
            FrotaAllDTO frotaAllDTO = new FrotaAllDTO();
            frotaAllDTO.setId(frota.getIdFrota());
            frotaAllDTO.setPlaca(frota.getPlaca());
            frotaAllDTO.setDataAdquirido(DateUtils.DateToString(frota.getDataAdquirido()));
            frotaAllDTO.setTipoVeiculo(TipoVeiculoEnum.fromCodigo(frota.getTipoVeiculo()).getDescricao());
            frotaAllDTO.setTipoCombustivel(TipoCombustivelEnum.fromCodigo(frota.getTipoCombustivel()).getDescricao());
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
        frotaAllDTO.setId(frota.getIdFrota());
        frotaAllDTO.setPlaca(frota.getPlaca());
        frotaAllDTO.setDataAdquirido(DateUtils.DateToString(frota.getDataAdquirido()));
        frotaAllDTO.setTipoVeiculo(TipoVeiculoEnum.fromCodigo(frota.getTipoVeiculo()).getDescricao());
        frotaAllDTO.setTipoCombustivel(TipoCombustivelEnum.fromCodigo(frota.getTipoCombustivel()).getDescricao());
        frotaAllDTO.setKmRodado(frota.getKmRodado());
        frotaAllDTO.setStatusFrota(frota.getStatusFrota());
        frotaAllDTO.setLeilao(frota.getLeilao());
        frotaAllDTO.setIdOrgao(frota.getIdOrgao().getNomeOrgao());
        frotaAllDTO.setIdCategoria(frota.getIdCategoria().getTipoCategoria());

        return frotaAllDTO;
    }

    public List<FrotaAllDTO> findAllFrota() {
        List<Frota> listFrota = repository.findAllByDeletadoIsFalse();
        return listToListDTO(listFrota);
    }

    public List<FrotaAllDTO> findVeiculosKmMaiorQueMedia(){
        List<Frota> listFrota = repository.findVeiculosKmMaiorQueMedia();
        return listToListDTO(listFrota);
    }

    public Frota findVeiculoByPlaca(String placa){
        return repository.findPlaca(placa);
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

    public Frota saveFrota(FrotaInsertDTO veiculoDTO){

        Frota veiculo = new Frota();
        veiculo.setPlaca(veiculoDTO.getPlaca());
        veiculo.setCor("");
        veiculo.setChassi(veiculoDTO.getChassi());
        veiculo.setRenavam(veiculoDTO.getRenavam());
        veiculo.setAnoFabricacao(veiculoDTO.getAnoModelo());
        veiculo.setTipoVeiculo(veiculoDTO.getVeiculo());
        veiculo.setNEixos(veiculoDTO.getNumeroEixos());
        veiculo.setDataAdquirido(veiculoDTO.getDataAquisicao());
        veiculo.setTipoVeiculo(veiculoDTO.getCombustivel());
        veiculo.setTanqueTotal(veiculoDTO.getCapacidadeTanque());
        veiculo.setKmRodado(veiculoDTO.getQuilometrosRodados());
        veiculo.setStatusFrota(false);
        veiculo.setLeilao(false);
        veiculo.setIdMarca(marcaRepository.findById(veiculoDTO.getMarca()).orElse(new Marca()));
        veiculo.setIdCategoria(categoriaRepository.findById(veiculoDTO.getModelo()).orElse(new Categoria()));
        veiculo.setIdOrgao(orgaoRepositoy.findById(veiculoDTO.getOrgao()).orElse(new Orgao()));

        return repository.save(veiculo);
    }

    public void deletarVeiculo(Long id){
            repository.updateDeletadoById(id);
    }
}



