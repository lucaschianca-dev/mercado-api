package com.mercado.apimercado.controllers;

import com.mercado.apimercado.DTO.AtualizaProdutoDTO;
import com.mercado.apimercado.DTO.ProdutoDTO;
import com.mercado.apimercado.entities.Produto;
import com.mercado.apimercado.enums.Tipo;
import com.mercado.apimercado.requests.ProdutoRegistroRequest;
import com.mercado.apimercado.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produtos")
@AllArgsConstructor
@CrossOrigin("*")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity registraProduto(@RequestBody ProdutoRegistroRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.registraProduto(request));
    }

    @GetMapping
    public ResponseEntity listaProdutosAtivos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listaProdutosAtivos());
    }

    @GetMapping("/inativos")
    public ResponseEntity listaProdutosInativos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listaProdutosInativos());
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity buscarTodosPorTipo(@PathVariable Tipo tipo, @PageableDefault(size = 10, page = 0, sort = "nome") Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarTodosPorTipo(tipo, pageable));
    }

    @GetMapping("/cod/{codigoBarras}")
    public ResponseEntity buscarPorCodigoBarras(@PathVariable String codigoBarras) {
        var produto = produtoService.buscarPorCodigoBarras(codigoBarras);

        return ResponseEntity.ok(produto);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscaPorId(@PathVariable Long id) {
        var produto = produtoService.buscarProId(id);

        if (produto == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(produto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizaProduto(@PathVariable Long id, @RequestBody @Valid AtualizaProdutoDTO atualizaProdutoDTO) {
        Produto produto = produtoService.atualizaProduto(id, atualizaProdutoDTO);

        return ResponseEntity.ok(produto);
    }

    @PutMapping("/ativa/{id}")
    public ResponseEntity ativaProduto(@PathVariable Long id) {
        Produto produto = produtoService.ativaProduto(id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/inativa/{id}")
    public ResponseEntity inativaProduto(@PathVariable Long id) {
        Produto produto = produtoService.inativaProduto(id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity excluiProduto(@PathVariable Long id) {
        produtoService.excluiProduto(id);

        return ResponseEntity.noContent().build();
    }
}
