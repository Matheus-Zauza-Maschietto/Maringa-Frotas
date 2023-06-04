package com.maringa.frotas.repository;

import com.maringa.frotas.domain.TipoRevisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRevisaoRepository extends JpaRepository<TipoRevisao, Long> {
}
