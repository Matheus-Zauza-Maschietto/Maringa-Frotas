package com.maringa.frotas.service;

import com.maringa.frotas.DTO.EmpresaDTO;
import com.maringa.frotas.domain.EmpresaRevisao;
import com.maringa.frotas.repository.EmpresaRevisaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmpresaRevisaoService {

    @Autowired
    private EmpresaRevisaoRepository repository;


    public List<EmpresaDTO> findAllDTO(){
        List<EmpresaRevisao> empresas = repository.findAll();
        List<EmpresaDTO> empresaDTO = new ArrayList<>();

        for (EmpresaRevisao empresa: empresas) {
            empresaDTO.add(EmpresaDTO.builder()
                    .id(empresa.getIdEmpRevisao())
                    .cnpj(empresa.getCnpjEmpresa().toString())
                    .cep(empresa.getCepEmpresa().toString())
                    .nome(empresa.getNomeEmpresa())
                    .telefone(empresa.getTelefoneEmpresa().toString())
                    .build()
            );
        }
        return empresaDTO;
    }

    public List<EmpresaRevisao> findAll(){
        return repository.findAll();

    }

    public EmpresaRevisao findById(Long id){
        return repository.findById(id).orElse(null);
    }

    public EmpresaRevisao saveEmpresa(EmpresaRevisao empresaRevisao){
        return repository.save(empresaRevisao);
    }

    public void deletarEmpresa(Long id){
        repository.updateDeletadoById(id);
    }
}
