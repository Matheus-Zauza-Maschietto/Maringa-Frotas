package com.maringa.frotas.service;

import com.maringa.frotas.DTO.FuncionarioDTO;
import com.maringa.frotas.DTO.Insert.FuncionarioInsertDTO;
import com.maringa.frotas.domain.Pessoa;
import com.maringa.frotas.repository.MotoristaRepository;
import com.maringa.frotas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private OrgaoService orgaoService;

    @Autowired
    private CargoService cargoService;


    public List<FuncionarioDTO> findAllPessoa() {
        List<Pessoa> pessoas = repository.findAll();
        return pessoaToDTO(pessoas);
    }

    public Pessoa findPessoaById(Long id) {
        return repository.findById(id).orElse(null);
    }


    private List<FuncionarioDTO> pessoaToDTO(List<Pessoa> listPessoa){

        List<FuncionarioDTO> listPessoaDTO = new ArrayList<>();

        for (Pessoa pessoaToDto: listPessoa) {
            FuncionarioDTO funcionarioDTO = new FuncionarioDTO();

            funcionarioDTO.setId(pessoaToDto.getIdPessoa());
            funcionarioDTO.setNome(pessoaToDto.getNome());
            funcionarioDTO.setCpf(pessoaToDto.getCpf());
            if (Objects.isNull(motoristaRepository.findByPessoa(pessoaToDto))){
                funcionarioDTO.setCnh("CNH não cadastrada");
            }else {
                funcionarioDTO.setCnh(motoristaRepository.findByPessoa(pessoaToDto).getCnh().toString());
            }
            funcionarioDTO.setOrgao(pessoaToDto.getIdOrgao().getNomeOrgao());
            funcionarioDTO.setCargo(pessoaToDto.getIdCargo().getNomecargo());

            listPessoaDTO.add(funcionarioDTO);
        }
        return listPessoaDTO;
    }

    public Pessoa salvarPessoa(FuncionarioInsertDTO pessoaDTO){

        Pessoa pessoa = Pessoa.builder()
                .nome(pessoaDTO.getNome())
                .cpf(pessoaDTO.getCpf())
                .email(pessoaDTO.getEmail())
                .telefone(pessoaDTO.getTelefone())
                .idCargo(cargoService.findById(pessoaDTO.getIdCargo()))
                .idOrgao(orgaoService.findById(pessoaDTO.getIdOrgao()))
                .build();

        return repository.save(pessoa);
    }

    public void deletarPessoa(Long id){
        repository.updateDeletadoById(id);
    }
}



