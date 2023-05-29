package com.maringa.frotas.service;

import com.maringa.frotas.domain.Abastecimento;
import com.maringa.frotas.domain.Revisao;
import com.maringa.frotas.repository.AbastecimentoRepository;
import com.maringa.frotas.repository.FrotaRepository;
import com.maringa.frotas.repository.RevisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RevisaoService {

    @Autowired
    private RevisaoRepository repository;
    @Autowired
    private FrotaRepository frotaRepository;




    public List<Revisao> findAll(){
        return repository.findAll();
    }

    public Revisao findById(Long id){
        return repository.findById(id).orElse(null);

    }

    public List<Revisao> findByIdVeiculo(Long id){
        List<Revisao> revisaoList = repository.findAllByIdFrota(frotaRepository
                .findById(id).orElse(null));
        return revisaoList;
    }



}
