package com.maringa.frotas.repository;

import com.maringa.frotas.domain.Frota;
import com.maringa.frotas.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    public Pessoa findByEmail(String email);

    String findAll = "select * from pessoa where deletado = 0";
    @Query(value = findAll, nativeQuery = true)
    public List<Pessoa> findAll();


    String sqlDeleteFrota =
            " update pessoa" +
                    "    set deletado = true " +
                    "  where idPessoa =  :id ";
    @Modifying
    @Query(value = sqlDeleteFrota, nativeQuery = true)
    void updateDeletadoById(@Param("id") Long id);
}
