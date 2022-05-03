package com.tuyo.tuyofood.listener;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.notificacao.NotificadorTipo;
import com.tuyo.tuyofood.notificacao.NotificadorUrgencia;
import com.tuyo.tuyofood.service.ClienteAtivadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/* AtivacaoClienteService publicou um evento e
* NotificacaoService 'escutou' este 'evento' */
@Component
public class NotificacaoService {

    @NotificadorTipo(NotificadorUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    /* 1. Este método é um 'ouvinte'
    * 2. É possível ter vários métodos listeners dentro da mesma classe. */
    @EventListener
    public void clienteAtivadoListener(ClienteAtivadoEvent event) {
        notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
    }

}
