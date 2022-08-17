package com.tuyo.tuyofood.domain.service;

import com.tuyo.tuyofood.domain.entity.Kitchen;
import com.tuyo.tuyofood.domain.exception.EntidadeEmUsoException;
import com.tuyo.tuyofood.domain.exception.EntidadeNaoEncontradaException;
import com.tuyo.tuyofood.domain.repository.KitchenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

/* 1. @Service = Também é um @Component
 *  2. Uma classe de Serviço não deve retornar um ResponseEntity porque essa classe de serviço é negócio.
 * Ele deve ficar na classe controladora KitchenController.
 *  3. E o tratamento de exceções deve ser feito aqui e não mais em KitchenController.
 *  4. Esta classe não pode ter acesso aquelas classes que estão implementando a API.
 *  5. Sendo uma Classe de Serviço, ela não tem nenhum conhecimento nenhum de protocolo HTTP.
 *  6. DataIntegrityViolationException: essa exceção é lançada quando uma kitchen está em uso por um Restaurant.
 * Ou seja, no cadastro de restaurantes tem um restaurant cadastrado para uma determinada kitchen. E estou
 * tentando excluir esta determinada kitchen mas não pode porque tem restaurants nessa determinada kitchen. E
 * por isso não posso excluir e lança essa exceção.
 *  7. EntidadeEmUsoException: é uma exceção de negócio.
 *  8. String.format: passar String em forma de código "%d"
 *  9. %d = integer (incl. byte, short, int, long, bigint)	Decimal Integer.
 * 10. orElseThrow = retorna o objeto que está dentro do Optional
 * 11. Constant: seleciona a mensagem -> btn right -> Refactor -> Introduce Constant*/

@Service
public class KitchenRegisterService {

    public static final String MSG_KITCHEN_NAO_ENCONTRADA
            = "There is no kitchen registration with code %d";

    public static final String MSG_KITCHEN_EM_USO
            = "Code kitchen %d cannot be removed as it is in use";

    @Autowired
    private KitchenRepository kitchenRepository;

    public Kitchen salvar(Kitchen kitchen) {
        return kitchenRepository.save(kitchen);
    }

    public void excluir(Long kitchenId) {
        try {
            kitchenRepository.deleteById(kitchenId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_KITCHEN_NAO_ENCONTRADA, kitchenId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_KITCHEN_EM_USO, kitchenId));
        }
    }
    public Kitchen buscarOuFalhar(Long kitchenId) {
        return kitchenRepository.findById(kitchenId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_KITCHEN_NAO_ENCONTRADA, kitchenId)));
    }
}
