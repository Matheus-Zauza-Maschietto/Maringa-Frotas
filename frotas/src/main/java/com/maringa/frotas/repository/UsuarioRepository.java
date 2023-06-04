package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findUsuarioByLogin(String login);


}
