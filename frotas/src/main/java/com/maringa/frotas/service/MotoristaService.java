package com.maringa.frotas.service;

import com.maringa.frotas.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository repository;


    public List<com.maringa.frotas.domain.Motorista> findAllMotorista() {
        return repository.findAll();
    }


}



