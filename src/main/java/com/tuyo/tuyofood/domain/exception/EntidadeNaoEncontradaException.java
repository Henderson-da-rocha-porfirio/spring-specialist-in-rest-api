package com.tuyo.tuyofood.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/* 1. @ResponseStatus: retorno de status
 *  2. reason: mensagem customizada se quiser.
 *  3. value ou code é a mesma coisa: code = HttpStatus ...
 *  4. ResponseStatusException: esta classe anula a necessidade de usar @ResponseStatus aqui.
 *  5. Vantagem é ter uma única classe exception com vários status http*/

// @ResponseStatus(value = HttpStatus.NOT_FOUND) //, reason = "Entidade não encontrada")
public class EntidadeNaoEncontradaException extends ResponseStatusException {

    private static final long serialVersionUID = 1L;

    public EntidadeNaoEncontradaException(HttpStatus status, String reason) {
        super(status, reason);
    }

    public EntidadeNaoEncontradaException(String reason) {
        this(HttpStatus.NOT_FOUND, reason);
    }

}