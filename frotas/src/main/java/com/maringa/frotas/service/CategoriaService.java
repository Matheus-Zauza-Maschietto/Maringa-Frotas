package com.maringa.frotas.service;

import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.domain.Marca;
import com.maringa.frotas.repository.CategoriaRepository;
import com.maringa.frotas.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public Categoria findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Categoria saveCategoria(Categoria categoria){
        return repository.save(categoria);
    }

}
