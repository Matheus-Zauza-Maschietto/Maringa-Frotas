package com.maringa.frotas.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ManutencaoDTO implements Serializable {

    private Long id;

    private Double custo;


}
