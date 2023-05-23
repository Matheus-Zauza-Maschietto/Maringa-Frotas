package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Categoria;
import com.maringa.frotas.domain.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
