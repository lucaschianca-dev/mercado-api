package com.mercado.apimercado.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mercado.apimercado.DTO.AtualizaProdutoDTO;
import com.mercado.apimercado.enums.Tipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@Table(name = "produtos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private BigDecimal preco;

    private String validade;

    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    private String codigoBarras = UUID.randomUUID().toString();

    @Column(columnDefinition = "TEXT")
    private String descricaoCurta;

    @Column(columnDefinition = "TEXT")
    private String descricaoLonga;

    private boolean ativo = true;

    public void atualizaProduto(AtualizaProdutoDTO atualizaProdutoDTO) {
        if (atualizaProdutoDTO.getNome() != null) {
            this.nome = atualizaProdutoDTO.getNome();
        }

        if (atualizaProdutoDTO.getPreco() != null) {
            this.preco = atualizaProdutoDTO.getPreco();
        }

        if (atualizaProdutoDTO.getValidade() != null) {
            this.validade = atualizaProdutoDTO.getValidade();
        }

        if (atualizaProdutoDTO.getTipo() != null) {
            this.tipo = atualizaProdutoDTO.getTipo();
        }

        if (atualizaProdutoDTO.getDescricaoCurta() != null) {
            this.descricaoCurta = atualizaProdutoDTO.getDescricaoCurta();
        }

        if (atualizaProdutoDTO.getDescricaoLonga() != null) {
            this.descricaoLonga = atualizaProdutoDTO.getDescricaoLonga();
        }
    }


    public void ativaProduto() {
        this.ativo = true;
    }

    public void inativaProduto() {
        this.ativo = false;
    }
}
