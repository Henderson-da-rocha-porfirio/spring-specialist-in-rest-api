package com.tuyo.tuyofood.notificacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import org.springframework.stereotype.Component;

/*@Component*/
public class NotificadorEmail implements Notificador {

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}

