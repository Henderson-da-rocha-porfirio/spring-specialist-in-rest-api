package com.tuyo.tuyofood.domain.exception;

/* 1. EntidadeNaoEncontradaException: essa hierarquia permite que se:
*  a. Deseja fazer um catch mais genérico usa EntidadeNaoEncontradaException.
*  b. Deseja fazer um catch mais específico usa StateNaoEncontradoException.
*  2. @ResponseStatus(value = HttpStatus.NOT_FOUND): foi removido porque EntidadeNaoEncontradaException
* já tem o @ResponseStatus. Mas se quiser deixar explícito não tem problema.
*  3. this: está chamando o construtor StateNaoEncontradoException de cima (de acordo com o parâmetro).
*  4. Com dois construtores é possível especificar a reason(mensagem) ou passar o stateId e a própria exception
* já monta a mensagem colocada no format) */

public class StateNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public StateNaoEncontradoException(String reason) {
        super(reason);
    }

    public StateNaoEncontradoException(Long stateId) {

       this(String.format("Não existe um cadastro de estado com código %d", stateId));
    }

}