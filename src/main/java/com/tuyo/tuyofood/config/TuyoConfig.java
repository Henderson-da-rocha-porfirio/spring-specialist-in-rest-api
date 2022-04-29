package com.tuyo.tuyofood.config;

import com.tuyo.tuyofood.notificacao.NotificadorEmail;
import com.tuyo.tuyofood.service.AtivacaoClienteService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*Classe de configuração
 * 1. Recebe a anotação @Configuration
 * 2. Adicionar a anotação da classe @Configuration:
 * a. Também é um Component Spring.
 * b. Mas ela tem um objetivo principal: servir como uma classe de 'definição de beans'.
 * 3. Adicionar @Bean no método NotificadorEmail para: Inicializar, Instanciar e Configurar
 * um novo Objeto que será gerenciado pelo Container Spring. */

@Configuration
public class TuyoConfig {

   /* Método para instanciar e configurar um NotificadorEmail com um parâmetro 'smtp.tuyomail...'*/
    @Bean
    public NotificadorEmail notificadorEmail(){
        NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.tuyomail.com.br");

        /*Se quiser resposta contrária, sem caixa alta, só colocar false*/
        notificadorEmail.setCaixaAlta(true);

        return notificadorEmail;
    }

    /*notificadorEmail passado no parâmetro, ele já retorna como um Bean gerenciado pelo Spring por causa
    * da configuração do Bean acima. */
    @Bean
    public AtivacaoClienteService ativacaoClienteService(){
        return new AtivacaoClienteService(notificadorEmail());
    }
}
