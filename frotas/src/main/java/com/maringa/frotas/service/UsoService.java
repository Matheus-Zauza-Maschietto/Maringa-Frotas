package com.maringa.frotas.service;

import com.maringa.frotas.domain.Uso;
import com.maringa.frotas.repository.UsoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsoService {

    @Autowired
    private UsoRepository repository;

    public List<Uso> findAll(){
        return repository.findAll();
    }

    public Uso findById(Long id){
        return repository.findById(id).orElse(null);
    }

}
