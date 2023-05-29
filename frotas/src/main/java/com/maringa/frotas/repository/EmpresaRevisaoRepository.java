package com.maringa.frotas.repository;

import com.maringa.frotas.domain.EmpresaRevisao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRevisaoRepository extends JpaRepository<EmpresaRevisao, Long> {
}
