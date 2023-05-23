package com.maringa.frotas.service;

import com.maringa.frotas.domain.Marca;
import com.maringa.frotas.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository repository;

    public List<Marca> findAll(){
        return repository.findAll();
    }

    public Marca findById(Long id){
        return repository.findById(id).orElse(null);
    }

}
