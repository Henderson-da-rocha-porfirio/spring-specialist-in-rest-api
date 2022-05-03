package com.tuyo.tuyofood.service.ativacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import com.tuyo.tuyofood.notificacao.NotificadorEmail;
import com.tuyo.tuyofood.notificacao.NotificadorTipo;
import com.tuyo.tuyofood.notificacao.NotificadorUrgencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.swing.*;

/*@Component*/
public class AtivacaoClienteService {

    @NotificadorTipo(NotificadorUrgencia.SEM_URGENCIA)
    @Autowired
    private Notificador notificador;

    /*Mostra que o notificador já foi injetado*/
    /*@PostConstruct*/
    public void init() {
        System.out.println("INIT " + notificador);
    }

    /*Para o Constainer do Spring*/
    /*@PreDestroy*/
    public void destroy() {
        System.out.println("DESTROY");
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}