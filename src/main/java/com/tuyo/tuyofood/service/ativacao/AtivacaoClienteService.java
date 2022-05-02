package com.tuyo.tuyofood.service.ativacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import com.tuyo.tuyofood.notificacao.NotificadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {

    /*Estou informando ao Spring que tenho um qualificador chamado "email" ou "sms" */
    /*@Qualifier("email")*/
    /*@Qualifier("sms")*/
    @Qualifier("prioridade urgente")
    @Autowired
    private Notificador notificador;

    public void ativar(Cliente cliente) {
        cliente.ativar();

            notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}