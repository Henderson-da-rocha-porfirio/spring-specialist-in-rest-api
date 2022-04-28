package com.tuyo.tuyofood.notificacao;

import com.tuyo.tuyofood.modelo.Cliente;
import org.springframework.stereotype.Component;

/*Se eu quiser que o Spring gerencie essa classe, instancie e configure, e injete os objetos(beans) nela, é necessário "avisar" para ele:
1. usando @Component(com isso estou dizendo que esta classe virou um componente Spring.
2. Componentes Spring são instanciados por ele.
3. Com isso já temos um Bean Spring instanciado.*/

@Component
public class NotificadorEmail {

    public void notificar(Cliente cliente, String mensagem) {
        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
