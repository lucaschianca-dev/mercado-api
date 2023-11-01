package com.mercado.apimercado.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResposta> tratarErro500(Exception e) {
        ErroResposta erroResponse = new ErroResposta("Erro interno no servidor", e.getMessage());
        return ResponseEntity.status(500).body(erroResponse);
    }
}
