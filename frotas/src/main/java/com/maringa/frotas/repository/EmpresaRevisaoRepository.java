package com.maringa.frotas.repository;

import com.maringa.frotas.domain.EmpresaRevisao;
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
public interface EmpresaRevisaoRepository extends JpaRepository<EmpresaRevisao, Long> {

    String findAll = "select * from empresaRevisao where deletado = 0";
    @Query(value = findAll, nativeQuery = true)
    public List<EmpresaRevisao> findAll();


    String sqlDeleteFrota =
            " update empresaRevisao" +
                    "    set deletado = true " +
                    "  where idEmpRevisao =  :id ";
    @Modifying
    @Query(value = sqlDeleteFrota, nativeQuery = true)
    void updateDeletadoById(@Param("id") Long id);
}
