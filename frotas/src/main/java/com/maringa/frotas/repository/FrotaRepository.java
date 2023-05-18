package com.maringa.frotas.repository;

import com.maringa.frotas.DTO.FrotaAllDTO;
import com.maringa.frotas.domain.Frota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

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


    public Frota findFrotaByPlaca(String placa);

}
