package com.tuyo.tuyofood.config.ativacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.service.ativacao.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AtivacaoConfig {

     /* Passando como parâmetro a Interface Notificador, ou seja, ele poderá ser injetado*/
    @Bean
    public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
        return new AtivacaoClienteService(notificador);
    }
}
