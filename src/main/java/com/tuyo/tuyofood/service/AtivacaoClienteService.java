package com.tuyo.tuyofood.service;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import com.tuyo.tuyofood.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

/* B. Injeção de dependência: fazendo pelo construtor: "AtivacaoClienteService",
 * que recebe como parâmetro um objeto de um tipo: "NotificadorEmail"(que é um Bean gerenciado pelo Spring). */

@Component
public class AtivacaoClienteService {
    /*Injetar */
    private Notificador notificador;

    public AtivacaoClienteService(Notificador notificador) {
        this.notificador = notificador;

        System.out.println("AtivacaoClienteService: " + notificador);
    }

    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}