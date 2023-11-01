package com.mercado.apimercado.DTO;

import com.mercado.apimercado.enums.Tipo;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtualizaProdutoDTO {

    private String nome;

    private BigDecimal preco;

    private String validade;

    private Tipo tipo;

    private String descricaoCurta;

    private String descricaoLonga;
}
