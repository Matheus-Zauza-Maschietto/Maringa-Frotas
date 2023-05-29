package com.maringa.frotas.service;

import com.maringa.frotas.DTO.CargoDTO;
import com.maringa.frotas.domain.Cargo;
import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.repository.CargoRepositoy;
import com.maringa.frotas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepositoy repository;

    public List<CargoDTO> findAll(){
        List<Cargo> cargos = repository.findAll();
        List<CargoDTO> cargosDTO = new ArrayList<>();
        for (Cargo cargo: cargos) {
            cargosDTO.add(CargoDTO.builder()
                    .id(cargo.getIdCargo())
                    .text(cargo.getNomecargo())
                    .build());
        }
        return cargosDTO;
    }

    public Cargo findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Cargo saveCategoria(Cargo cargo){
        return repository.save(cargo);
    }

}
