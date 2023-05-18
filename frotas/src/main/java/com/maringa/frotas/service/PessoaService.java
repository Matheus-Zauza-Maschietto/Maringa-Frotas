package com.maringa.frotas.service;

import com.maringa.frotas.domain.Pessoa;
import com.maringa.frotas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;


    public List<Pessoa> findAllPessoa() {
        return repository.findAll();
    }


}



