package com.maringa.frotas.repository;

import com.maringa.frotas.DTO.FrotaAllDTO;
import com.maringa.frotas.domain.Frota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface FrotaRepository extends JpaRepository<Frota, Long> {

    String sqlSintaxe =
                    " select *" +
                    "   from frota f " +
                    "  where kmrodado > (" +
                    " select avg(kmrodado) " +
                    "   from frota)" +
                    "  order by kmrodado;";
    @Query(value = sqlSintaxe, nativeQuery = true)
    List<Frota> findVeiculosKmMaiorQueMedia();

    String findAll = "select * from frota where deletado = 0";
    @Query(value = findAll, nativeQuery = true)
    public List<Frota> findAllByDeletadoIsFalse();

    String findPlaca = "select * from frota where deletado = 0 and placa like (:placa) ";
    @Query(value = findPlaca, nativeQuery = true)
    public Frota findPlaca(@Param("placa") String placa);

    public Frota findFrotaByIdFrota(Long id);

    String sqlDeleteFrota =
                    " update frota" +
                    "    set deletado = true " +
                    "  where idFrota =  :id ";
    @Modifying
    @Query(value = sqlDeleteFrota, nativeQuery = true)
    void updateDeletadoById(@Param("id") Long id);

}
