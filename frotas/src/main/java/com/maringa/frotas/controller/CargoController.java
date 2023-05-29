package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.CargoDTO;
import com.maringa.frotas.domain.Cargo;
import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.service.CargoService;
import com.maringa.frotas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService service;

    @GetMapping
    public ResponseEntity<List<CargoDTO>> findCargos(){
        return ResponseEntity.ok(service.findAll());
    }
}
