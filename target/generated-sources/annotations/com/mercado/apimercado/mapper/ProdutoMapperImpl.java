package com.mercado.apimercado.mapper;

import com.mercado.apimercado.DTO.ProdutoDTO;
import com.mercado.apimercado.entities.Produto;
import com.mercado.apimercado.requests.ProdutoRegistroRequest;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-30T15:16:08-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public Produto toProduto(ProdutoRegistroRequest request) {
        if ( request == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setNome( request.getNome() );
        produto.setPreco( request.getPreco() );
        produto.setValidade( request.getValidade() );
        produto.setTipo( request.getTipo() );
        produto.setDescricaoCurta( request.getDescricaoCurta() );
        produto.setDescricaoLonga( request.getDescricaoLonga() );

        return produto;
    }

    @Override
    public ProdutoDTO toProdutoDTO(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setId( produto.getId() );
        produtoDTO.setNome( produto.getNome() );
        produtoDTO.setPreco( produto.getPreco() );
        produtoDTO.setValidade( produto.getValidade() );
        produtoDTO.setTipo( produto.getTipo() );
        produtoDTO.setCodigoBarras( produto.getCodigoBarras() );
        produtoDTO.setDescricaoCurta( produto.getDescricaoCurta() );
        produtoDTO.setDescricaoLonga( produto.getDescricaoLonga() );
        produtoDTO.setAtivo( produto.isAtivo() );

        return produtoDTO;
    }
}
