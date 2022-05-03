package com.tuyo.tuyofood.notificacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NotificadorTipo(NotificadorUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

    @Autowired
    private NotificadorProperties properties;

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.println("Host: " + properties.getHostServidor());
        System.out.println("Porta: " + properties.getPortaServidor());

        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}

