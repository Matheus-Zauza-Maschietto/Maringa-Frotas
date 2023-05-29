package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepositoy extends JpaRepository<Cargo, Long> {
}
