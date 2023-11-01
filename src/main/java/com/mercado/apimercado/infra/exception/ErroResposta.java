package com.mercado.apimercado.infra.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErroResposta {
    private String mensagem;
    private String detalhes;
}
