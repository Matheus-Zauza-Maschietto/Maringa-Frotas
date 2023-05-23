package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Abastecimento;
import com.maringa.frotas.domain.Frota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Long> {

    public List<Abastecimento> findAllByIdFrota(Frota frota);
}
