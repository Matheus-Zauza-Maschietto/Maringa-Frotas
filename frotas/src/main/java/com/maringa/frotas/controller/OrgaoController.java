package com.maringa.frotas.controller;

import com.maringa.frotas.DTO.CargoDTO;
import com.maringa.frotas.DTO.OrgaoDTO;
import com.maringa.frotas.service.CargoService;
import com.maringa.frotas.service.OrgaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orgaos")
public class OrgaoController {

    @Autowired
    private OrgaoService service;

    @GetMapping
    public ResponseEntity<List<OrgaoDTO>> findCargos(){
        return ResponseEntity.ok(service.findAll());
    }
}
