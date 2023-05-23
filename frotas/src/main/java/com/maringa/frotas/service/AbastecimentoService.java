package com.maringa.frotas.service;

import com.maringa.frotas.domain.Abastecimento;
import com.maringa.frotas.repository.AbastecimentoRepository;
import com.maringa.frotas.repository.FrotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbastecimentoService {

    @Autowired
    private AbastecimentoRepository repository;
    @Autowired
    private FrotaRepository frotaRepository;

    private static void setValorTotal(Abastecimento abastecimento){
        abastecimento.setValorTotal(abastecimento.getValorLitro() * abastecimento.getLitrosAbastecidos());
    }


    public List<Abastecimento> findAll(){
        List<Abastecimento> abastecimentoList = repository.findAll();
        abastecimentoList.forEach(AbastecimentoService::setValorTotal);
        return abastecimentoList;
    }

    public Abastecimento findById(Long id){
        Abastecimento abastecimento = repository.findById(id).orElse(null);
        setValorTotal(abastecimento);
        return abastecimento;
    }

    public List<Abastecimento> findByIdVeiculo(Long id){
        List<Abastecimento> abastecimentoList = repository.findAllByIdFrota(frotaRepository
                .findById(id).orElse(null));
        abastecimentoList.forEach(AbastecimentoService::setValorTotal);
        return abastecimentoList;
    }



}
