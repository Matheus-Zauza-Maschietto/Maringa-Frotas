package com.maringa.frotas.service;

import com.maringa.frotas.DTO.*;
import com.maringa.frotas.domain.Frota;
import com.maringa.frotas.domain.Motorista;
import com.maringa.frotas.domain.Viagem;
import com.maringa.frotas.repository.MotoristaRepository;
import com.maringa.frotas.repository.PessoaRepository;
import com.maringa.frotas.repository.ViagemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository repository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ViagemRepository viagemRepository;

    @Autowired
    private FrotaService frotaService;

    private MotoristaDTO motoristaToMotoristaDTO(Motorista motorista){

        MotoristaDTO dto = new MotoristaDTO();

            dto.setId(motorista.getPessoa().getIdPessoa());
            dto.setNome(motorista.getPessoa().getNome());
            dto.setCpf(motorista.getPessoa().getCpf());
            dto.setEmail(motorista.getPessoa().getEmail());
            dto.setTelefone(motorista.getPessoa().getTelefone().intValue());
            dto.setCnh(motorista.getCnh().intValue());
            dto.setOrgao(motorista.getPessoa().getIdOrgao().getNomeOrgao());
            dto.setCargo(motorista.getPessoa().getIdCargo().getNomecargo());



        return dto;
    }

    private List<MotoristaDTO> motoristasToMotoristaDTO(List<Motorista> motoristas){
        List<MotoristaDTO> motoristaDTOS = new ArrayList<>();

        for (Motorista motorista: motoristas) {
            MotoristaDTO dto = new MotoristaDTO();
            dto.setId(motorista.getPessoa().getIdPessoa());
            dto.setNome(motorista.getPessoa().getNome());
            dto.setCpf(motorista.getPessoa().getCpf());
            dto.setEmail(motorista.getPessoa().getEmail());
            dto.setTelefone(motorista.getPessoa().getTelefone().intValue());
            dto.setCnh(motorista.getCnh().intValue());
            dto.setOrgao(motorista.getPessoa().getIdOrgao().getNomeOrgao());
            dto.setCargo(motorista.getPessoa().getIdCargo().getNomecargo());

            motoristaDTOS.add(dto);
        }
        return motoristaDTOS;
    }

    public List<MotoristaDTO> findAllMotorista() {
        return motoristasToMotoristaDTO(repository.findAll());
    }

    public MotoristaDTO findById(Long id) {
        return motoristaToMotoristaDTO(repository
                .findByPessoa(pessoaRepository
                        .findById(id).orElse(null)));
    }

    public MotoristaViagemDTO viagemMotorista(Long id){

        Motorista motorista = repository.findByPessoa(pessoaRepository.findById(id).orElse(null));

        MotoristaViagemDTO dto = new MotoristaViagemDTO();
        dto.setId(motorista.getPessoa().getIdPessoa());
        dto.setCnh(motorista.getCnh());
        dto.setPessoa(motorista.getPessoa());

        List<ViagemToPessoaDTO> listDTO = new ArrayList<>();

        List<Viagem> viagens = viagemRepository.findByIdMotorista(motorista);
        for (Viagem viagem: viagens) {
            ViagemToPessoaDTO viagemDTO = new ViagemToPessoaDTO();
            viagemDTO.setIdViagem(viagem.getIdViagem());
            viagemDTO.setKilometragemViagem(viagem.getKilometragemViagem());
            viagemDTO.setSaidaFrota(viagem.getSaidaFrota());
            viagemDTO.setEntradaFrota(viagem.getEntradaFrota());
            viagemDTO.setIdUso(viagem.getIdUso());
            viagemDTO.setFrota(frotaService.frotaToFrotaDTO(viagem.getIdVeiculo()));
            listDTO.add(viagemDTO);
        }

        dto.setViagens(listDTO);

        return dto;

    }

}



