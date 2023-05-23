package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Uso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsoRepository extends JpaRepository<Uso, Long> {

}
