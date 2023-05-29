package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Abastecimento;
import com.maringa.frotas.domain.Frota;
import com.maringa.frotas.domain.Revisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevisaoRepository extends JpaRepository<Revisao, Long> {

    public List<Revisao> findAllByIdFrota(Frota frota);
}
