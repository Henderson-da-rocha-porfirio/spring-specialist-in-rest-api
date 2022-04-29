package com.tuyo.tuyofood.notificacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import org.springframework.stereotype.Component;

/*Instanciar e configurar o bean e torná-lo disponível para o container do Spring.
* 1. Remove ou não adiciona o @Component*/


public class NotificadorEmail implements Notificador {

    /*1. Início da implementação, criação de variável caixaAlta: Quando a caixaAlta estiver 'True' a mensagem ficará uppercase.
     Quando 'False', daí não fará nada.*/
    private boolean caixaAlta;

    /*2. Variável: hostServidorSmtp(servidor de email teste) que será passada no construtor NotificadorEmail. */
    private String hostServidorSmtp;

    /*3. Passando hostServidorSmtp no parâmetro para recebê-lo.*/
    public NotificadorEmail(String hostServidorSmtp) {
        this.hostServidorSmtp = hostServidorSmtp;
        System.out.println("NotificadorEmail");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        /*4. Criando o if que possibilita que seja executada o tipo da variável.*/
        if (this.caixaAlta) {
            mensagem = mensagem.toUpperCase();
        }

        /*5. Introduzindo na impressão hostServidorSmtp*/
        System.out.printf("Notificando %s através do e-mail %s usando SMTP %s: %s\n",
                cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp, mensagem);
    }
    /*6. Criação do setCaixaAlta */
    public void setCaixaAlta(boolean caixaAlta) {
        this.caixaAlta = caixaAlta;
    }
}
