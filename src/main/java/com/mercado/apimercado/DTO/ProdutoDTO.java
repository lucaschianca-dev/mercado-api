package com.mercado.apimercado.DTO;

import com.mercado.apimercado.entities.Produto;
import com.mercado.apimercado.enums.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;

    private String nome;

    private BigDecimal preco;

    private String validade;

    private Tipo tipo;

    private String codigoBarras;

    private String descricaoCurta;

    private String descricaoLonga;

    private boolean ativo;

    public ProdutoDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
        this.validade = produto.getValidade();
        this.tipo = produto.getTipo();
        this.codigoBarras = produto.getCodigoBarras();
        this.descricaoCurta = produto.getDescricaoCurta();
        this.descricaoLonga = produto.getDescricaoLonga();
        this.ativo = produto.isAtivo();
    }
}
