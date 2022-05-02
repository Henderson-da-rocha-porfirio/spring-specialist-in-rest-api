package com.tuyo.tuyofood.service.ativacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import com.tuyo.tuyofood.notificacao.NotificadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/* @Autowired (maneiras):
 * 1. É usada se houver mais de um construtor acima do construtor que eu deseja que seja feita a injeção de dependência.
 * 1.1 = Utilizar no construtor é o ideal: porque deixa muito claro que ao ser instanciada uma nova classe quais são as dependências obrigatórias daquela classe.
 * 2. Se houver apenas um construtor, a anotação @Autowired fica opcional.
 * 3. Um método set pode ser chamado com @autowired. Por exemplo, se houvesse alí um 'setNotificador'.
 * 4. Outro jeito é acima do atributo:*/

@Component
public class AtivacaoClienteService {
    // @Autowired: 4
    @Autowired
    private Notificador notificador;

   /* private @Autowired Notificador notificador;
    ou
    @Autowired private Notificador notificador;*/

    //	@Autowired: 1 & 2
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	}
//
//	public AtivacaoClienteService(String qualquer) {
//
//	}

    public void ativar(Cliente cliente) {
        cliente.ativar();

//        if (notificador != null) {
            notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
//        }  else {
//            System.out.println("Não existe notificador, mas cliente foi ativado");
//        }

        //	@Autowired: 3
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
    }
}