package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Frota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrotaRepository extends JpaRepository<Frota, Long> {


}
