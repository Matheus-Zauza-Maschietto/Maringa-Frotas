package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Frota;
import com.maringa.frotas.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    public Usuario findUsuarioByLogin(String login);




    String sqlSintaxe =
                    " select *" +
                    "   from Usuario u " +
                    "  where u.login = :login" +
                    "    and u.senha = :senha ";
    @Query(value = sqlSintaxe, nativeQuery = true)
    public Usuario findUsuarioByLoginAndSenha(@Param("login") String login, @Param("senha") String senha);
}
