package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Cargo;
import com.maringa.frotas.domain.Orgao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrgaoRepositoy extends JpaRepository<Orgao, Long> {
}
