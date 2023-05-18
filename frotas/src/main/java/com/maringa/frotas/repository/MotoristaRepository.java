package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Motorista;
import com.maringa.frotas.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Pessoa> {


}
