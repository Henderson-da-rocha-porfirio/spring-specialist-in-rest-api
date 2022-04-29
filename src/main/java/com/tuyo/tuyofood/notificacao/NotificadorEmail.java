package com.tuyo.tuyofood.notificacao;

import com.tuyo.tuyofood.interfaces.notificacao.Notificador;
import com.tuyo.tuyofood.modelo.Cliente;
import org.springframework.stereotype.Component;

/*Se eu quiser que o Spring gerencie essa classe, instancie e configure, e injete os objetos(beans) nela, é necessário "avisar" para ele:
A. usando @Component(com isso estou dizendo que esta classe virou um componente Spring.
1. Componentes Spring são instanciados por ele.
2. Com isso já temos um Bean Spring instanciado.
3. Se remover ou não tiver o "@Component" desta classe, dará o erro:
 - 'Consider defining a bean type': que significa que a injeção de dependência feita
 em "AtivacaoClienteService", não está encontrando essa 'injeção' feita nessa.
 4. Gerando Interface: btn direito -> Refactor -> Extract Interface*/

@Component
public class NotificadorEmail implements Notificador {

    public NotificadorEmail() {
        System.out.println("NotificadorEmail");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
