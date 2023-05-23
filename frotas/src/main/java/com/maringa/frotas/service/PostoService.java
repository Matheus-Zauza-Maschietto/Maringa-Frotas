package com.maringa.frotas.service;

import com.maringa.frotas.domain.Posto;
import com.maringa.frotas.repository.PostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostoService {

    @Autowired
    private PostoRepository repository;

    public List<Posto> findAll(){
        return repository.findAll();
    }

    public Posto findById(Long id){
        return repository.findById(id).orElse(null);
    }

}
