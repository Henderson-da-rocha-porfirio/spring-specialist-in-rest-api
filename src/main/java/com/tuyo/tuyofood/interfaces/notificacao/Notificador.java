package com.tuyo.tuyofood.interfaces.notificacao;

import com.tuyo.tuyofood.modelo.Cliente;

public interface Notificador {
    void notificar(Cliente cliente, String mensagem);
}
