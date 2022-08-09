package com.tuyo.tuyofood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* 1. @ResponseStatus: retorno de status
*  2. reason: mensagem customizada se quiser.
*  3. value ou code é a mesma coisa: code = HttpStatus ...
* */

@ResponseStatus(value = HttpStatus.NOT_FOUND) //, reason = "Entidade não encontrada")
public class EntidadeNaoEncontradaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}