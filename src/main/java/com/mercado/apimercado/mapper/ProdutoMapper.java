package com.mercado.apimercado.mapper;

import com.mercado.apimercado.DTO.ProdutoDTO;
import com.mercado.apimercado.entities.Produto;
import com.mercado.apimercado.requests.ProdutoRegistroRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProdutoMapper {
    
    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto toProduto(ProdutoRegistroRequest request);

    ProdutoDTO toProdutoDTO(Produto produto);
}
