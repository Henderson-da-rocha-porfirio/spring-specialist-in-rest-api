package com.tuyo.tuyofood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/* 1. EntidadeNaoEncontradaException: essa hierarquia permite que se:
*  a. Deseja fazer um catch mais genérico usa EntidadeNaoEncontradaException.
*  b. Deseja fazer um catch mais específico usa StateNaoEncontradoException.  */

@ResponseStatus(value = HttpStatus.NOT_FOUND) //, reason = "Entidade não encontrada")
public class StateNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public StateNaoEncontradoException(String reason) {
        super(reason);
    }

}