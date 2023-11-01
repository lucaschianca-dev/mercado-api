package com.mercado.apimercado.service;

import com.mercado.apimercado.DTO.AtualizaProdutoDTO;
import com.mercado.apimercado.DTO.ProdutoDTO;
import com.mercado.apimercado.entities.Produto;
import com.mercado.apimercado.enums.Tipo;
import com.mercado.apimercado.mapper.ProdutoMapper;
import com.mercado.apimercado.repositories.ProdutoRepository;
import com.mercado.apimercado.requests.ProdutoRegistroRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    @Transactional
    public ProdutoDTO registraProduto(@Valid ProdutoRegistroRequest request) {
        Produto produto = produtoRepository.save(ProdutoMapper.INSTANCE.toProduto(request));
        return ProdutoMapper.INSTANCE.toProdutoDTO(produto);
    }
    public List<Produto> listaProdutosAtivos() {
        List<Produto> produtosAtivos = produtoRepository.findAllByAtivoTrue();

        return produtosAtivos;
    }

    public List<Produto> listaProdutosInativos() {
        List<Produto> produtosInativos = produtoRepository.findAllByAtivoFalse();

        return produtosInativos;
    }

    public Page<ProdutoDTO> buscarTodosPorTipo(Tipo tipo, Pageable pageable) {
        Page<ProdutoDTO> produtos = produtoRepository.findAllByTipo(tipo, pageable).map(ProdutoMapper.INSTANCE::toProdutoDTO);

        return produtos;
    }

    public ProdutoDTO buscarPorCodigoBarras(String codigoBarras) {
        Produto produto = produtoRepository.findAllByCodigoBarras(codigoBarras);

        return new ProdutoDTO(produto);
    }

    public ProdutoDTO buscarProId(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);

        return new ProdutoDTO(produto);
    }

    @Transactional
    public Produto atualizaProduto(Long id, AtualizaProdutoDTO produtoDTO) {
        Produto produto = produtoRepository.findById(id).orElseThrow();
        produto.atualizaProduto(produtoDTO);

        return produto;
    }

    @Transactional
    public Produto inativaProduto(Long id) {
        Produto produto = produtoRepository.getReferenceById(id);
        produto.inativaProduto();

        return produto;
    }

    @Transactional
    public Produto ativaProduto(Long id) {
        Produto produto = produtoRepository.getReferenceById(id);
        produto.ativaProduto();

        return produto;
    }

    @Transactional
    public void excluiProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
