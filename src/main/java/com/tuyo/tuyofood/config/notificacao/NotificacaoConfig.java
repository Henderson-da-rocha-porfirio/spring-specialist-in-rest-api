package com.tuyo.tuyofood.config.notificacao;

import com.tuyo.tuyofood.notificacao.NotificadorEmail;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificacaoConfig {
    /* Método para instanciar e configurar um NotificadorEmail com um parâmetro 'smtp.tuyomail...'*/
    @Bean
    public NotificadorEmail notificadorEmail() {
        NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.tuyomail.com.br");

        /*Se quiser resposta contrária, sem caixa alta, só colocar false*/
        notificadorEmail.setCaixaAlta(true);

        return notificadorEmail;
    }
}
