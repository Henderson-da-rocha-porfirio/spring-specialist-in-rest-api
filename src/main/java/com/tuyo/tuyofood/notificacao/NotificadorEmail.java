package com.tuyo.tuyofood.notificacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/*@Profile("prod") = informa que o component NotificadorEmail será registrado no container do Spring apenas se ele estiver
* rodando no ambiente de produção. */

@Profile("prod")
@NotificadorTipo(NotificadorUrgencia.SEM_URGENCIA)
@Component
public class NotificadorEmail implements Notificador {

    /* Construtor: se ele não estiver num ambiente de produção, este Bean não é nem instanciado.
    * Ele fica desconhecido pelo container do Spring. */
    public NotificadorEmail() {
        System.out.println("NotificadorEmail REAL");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }

}

