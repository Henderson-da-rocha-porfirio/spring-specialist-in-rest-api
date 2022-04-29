package com.tuyo.tuyofood.service;

import com.tuyo.tuyofood.modelo.Cliente;
import com.tuyo.tuyofood.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;

/* B. Injeção de dependência: fazendo pelo construtor: "AtivacaoClienteService",
* que recebe como parâmetro um objeto de um tipo: "NotificadorEmail"(que é um Bean gerenciado pelo Spring).

* * Processo de Injeção de dependência:*/
/*1ª Apontar primeiro que a classe é um Bean com @Component:*/
@Component
public class AtivacaoClienteService {
    /*2ª Injetar o Bean*/
    private NotificadorEmail notificador;

    /*3ª Gerando o Construtor*/
    /*Gerando construtor: btn right ->  generate -> Constructor*/
    public AtivacaoClienteService(NotificadorEmail notificador) {
        this.notificador = notificador;

        /*Chamando o Construtor como exemplo*/
        System.out.println("AtivacaoClienteService: " + notificador);
    }

    /*4ª Chamando o método ativar do Bean ExampleController que está sendo injetada pelo Construtor
     aqui e também lá no outro bean, que tanto ativa quanto notifica.*/
    public void ativar(Cliente cliente) {
        cliente.ativar();

        notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}