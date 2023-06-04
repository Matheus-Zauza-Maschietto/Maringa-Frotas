package com.maringa.frotas.controller;


import com.maringa.frotas.domain.TipoRevisao;
import com.maringa.frotas.domain.Uso;
import com.maringa.frotas.service.TipoRevisaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/manutencoes/tipos")
public class TipoManutencaoController {

    @Autowired
    private TipoRevisaoService service;

    @GetMapping
    public ResponseEntity<List<TipoRevisao>> findAllUso(){
        return ResponseEntity.ok(service.findAll());
    }

}
