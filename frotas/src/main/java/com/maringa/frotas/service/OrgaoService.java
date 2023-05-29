package com.maringa.frotas.service;

import com.maringa.frotas.DTO.CargoDTO;
import com.maringa.frotas.DTO.OrgaoDTO;
import com.maringa.frotas.domain.Cargo;
import com.maringa.frotas.domain.Orgao;
import com.maringa.frotas.repository.CargoRepositoy;
import com.maringa.frotas.repository.OrgaoRepositoy;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrgaoService {

    @Autowired
    private OrgaoRepositoy repository;

    public List<OrgaoDTO> findAll(){
        List<Orgao> orgaos = repository.findAll();
        List<OrgaoDTO> cargosDTO = new ArrayList<>();
        for (Orgao orgao: orgaos) {
            cargosDTO.add(OrgaoDTO.builder()
                    .id(orgao.getIdOrgao())
                    .text(orgao.getNomeOrgao())
                    .build());
        }
        return cargosDTO;
    }

    public Orgao findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public Orgao saveCategoria(Orgao orgao){
        return repository.save(orgao);
    }

}
