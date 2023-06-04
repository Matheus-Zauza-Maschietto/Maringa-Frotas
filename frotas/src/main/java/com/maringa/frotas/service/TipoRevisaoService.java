package com.maringa.frotas.service;

import com.maringa.frotas.domain.TipoRevisao;
import com.maringa.frotas.repository.TipoRevisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoRevisaoService {

    @Autowired
    private TipoRevisaoRepository repository;

    public List<TipoRevisao> findAll(){
        return repository.findAll();
    }

    public TipoRevisao findbyId(Long id){
        return repository.findById(id).orElse(null);
    }
}
