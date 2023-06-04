package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Frota;
import com.maringa.frotas.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    public Pessoa findByEmail(String email);

}
