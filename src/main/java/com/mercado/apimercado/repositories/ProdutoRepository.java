package com.mercado.apimercado.repositories;

import com.mercado.apimercado.DTO.ProdutoDTO;
import com.mercado.apimercado.entities.Produto;
import com.mercado.apimercado.enums.Tipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Page<Produto> findAllByAtivoTrue(Pageable pageable);

    Produto findAllByCodigoBarras(String codigoBarra);

    Produto findAllByNome(String nome);

    @Query("SELECT P FROM Produto P WHERE P.tipo = :tipo AND P.ativo = true")
    Page<Produto> findAllByTipo(Tipo tipo, Pageable pageable);
}
