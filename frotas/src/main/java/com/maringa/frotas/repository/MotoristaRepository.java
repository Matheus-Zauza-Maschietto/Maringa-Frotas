package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Motorista;
import com.maringa.frotas.domain.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Pessoa> {


    public Motorista findByPessoa(Pessoa pessoa);

}
