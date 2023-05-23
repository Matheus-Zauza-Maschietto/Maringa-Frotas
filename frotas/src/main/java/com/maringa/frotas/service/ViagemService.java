package com.maringa.frotas.service;

import com.maringa.frotas.domain.Viagem;
import com.maringa.frotas.repository.ViagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository repository;

    public List<Viagem> findAllViagens(){
        return repository.findAll();
    }

    public Viagem findViagemById(Long id){
        return repository.findById(id).orElse(null);
    }


}
