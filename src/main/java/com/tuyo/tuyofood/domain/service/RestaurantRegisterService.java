package com.tuyo.tuyofood.domain.service;

import com.tuyo.tuyofood.domain.entity.Kitchen;
import com.tuyo.tuyofood.domain.entity.Restaurant;
import com.tuyo.tuyofood.domain.exception.EntidadeNaoEncontradaException;
import com.tuyo.tuyofood.domain.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* 1. isEmpty = Responde a pergunta: Está vazio aí dentro?
 *  2. .orElseThrow = pede o retorno da cozinha que está dentro do Optional, ou seja, como se fosse usando o isEmpty.
 * caso contrário, ele retorna a exceção EntidadeNaoEncontradaException. */
@Service
public class RestaurantRegisterService {

    private static final String MSG_RESTAURANTE_NAO_ENCONTRADO = "Não existe um cadastro de restaurante com código %d";
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private KitchenRegisterService kitchenRegisterService;

    public Restaurant salvar(Restaurant restaurant) {
        Long kitchenId = restaurant.getKitchen().getId();

        Kitchen kitchen = kitchenRegisterService.buscarOuFalhar(kitchenId);

        restaurant.setKitchen(kitchen);

        return restaurantRepository.save(restaurant);
    }

    public Restaurant buscarOuFalhar(Long restaurantId) {
        return restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restaurantId)));
    }
}
