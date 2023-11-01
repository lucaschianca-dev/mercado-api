package com.mercado.apimercado.requests;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercado.apimercado.enums.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoRegistroRequest {

    @NotBlank
    private String nome;

    @NotNull
    private BigDecimal preco;

    @NotNull
    private String validade;

    private Tipo tipo;

    private String descricaoCurta;

    private String descricaoLonga;
}
