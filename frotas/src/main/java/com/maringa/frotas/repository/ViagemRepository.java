package com.maringa.frotas.repository;

import com.maringa.frotas.DTO.MotoristaViagemDTO;
import com.maringa.frotas.domain.Frota;
import com.maringa.frotas.domain.Motorista;
import com.maringa.frotas.domain.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    public List<Viagem> findByIdVeiculo(Frota frota);
    public List<Viagem> findByIdMotorista(Motorista motorista);

}
