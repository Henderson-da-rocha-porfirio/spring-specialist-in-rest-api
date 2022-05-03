package com.tuyo.tuyofood.service.ativacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import com.tuyo.tuyofood.notificacao.NotificadorEmail;
import com.tuyo.tuyofood.notificacao.NotificadorTipo;
import com.tuyo.tuyofood.notificacao.NotificadorUrgencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    @NotificadorTipo(NotificadorUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

            notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}