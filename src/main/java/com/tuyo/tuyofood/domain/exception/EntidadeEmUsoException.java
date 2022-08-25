package com.tuyo.tuyofood.domain.exception;

/* 1. RuntimeException: mostrar que herda de UncheckedException
*  2. super: é o RuntimeException. Ou seja, ele chama o construtor RuntimeException
* que recebe uma mensagem. */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* 1. BusinessException: essa herança vem da hierarquia de RuntimeException, uma vez que BusinessException herda
 de RuntimeException. Isso é muito bom para definir hierarquias de exceptions específicas ou genéricas
 dependendo do caso. */

@ResponseStatus(HttpStatus.CONFLICT)
public class EntidadeEmUsoException extends BusinessException {

    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String mensagem) {
        super(mensagem);
    }

}