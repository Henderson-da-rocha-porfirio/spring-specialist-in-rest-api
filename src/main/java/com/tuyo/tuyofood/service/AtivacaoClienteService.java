package com.tuyo.tuyofood.service;

import com.tuyo.tuyofood.modelo.Cliente;
import com.tuyo.tuyofood.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    /*Variavél instância dessa classe. Sempre estará nulo porque ninguém está atribuindo ela.*/
    private NotificadorEmail notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
