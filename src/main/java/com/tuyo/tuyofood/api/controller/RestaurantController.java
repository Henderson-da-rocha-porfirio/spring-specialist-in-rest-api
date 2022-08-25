package com.tuyo.tuyofood.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuyo.tuyofood.domain.entity.Restaurant;
import com.tuyo.tuyofood.domain.repository.RestaurantRepository;
import com.tuyo.tuyofood.domain.service.RestaurantRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/* 1. ObjectMapper: converte objetos json em java e vice-versa
 *  2. paymentForms: é adicionado para que as outras formas não sejam deletadas sem necessidade.
 *  3. address: é adicionado para que os outros dados não sejam deletados sem necessidade.
 *  4. dataCadastro: também sofre o mesmo processo de address e paymentForms.
 *  5. O uso dos três acima como parâmetro, evita o erro:
 *  'ERROR: null value in column "data_cadastro" violates not-null constraint' */

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private RestaurantRegisterService restaurantRegisterService;

    @GetMapping
    public List<Restaurant> listar() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{restaurantId}")
    public Restaurant buscar(@PathVariable Long restaurantId) {
        return restaurantRegisterService.buscarOuFalhar(restaurantId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurant adicionar(@RequestBody Restaurant restaurant) {
        return restaurantRegisterService.salvar(restaurant);
    }

    @PutMapping("/{restaurantId}")
    public Restaurant atualizar(@PathVariable Long restaurantId,
                                @RequestBody Restaurant restaurant) {
        Restaurant restaurantAtual = restaurantRegisterService.buscarOuFalhar(restaurantId);

        BeanUtils.copyProperties(restaurant, restaurantAtual,
                "id", "formasPagamento", "endereco", "dataCadastro", "produtos");

        return restaurantRegisterService.salvar(restaurantAtual);
    }

    @PatchMapping("/{restaurantId}")
    public Restaurant atualizarParcial(@PathVariable Long restaurantId,
                                       @RequestBody Map<String, Object> campos) {
        Restaurant restaurantAtual = restaurantRegisterService.buscarOuFalhar(restaurantId);

        merge(campos, restaurantAtual);

        return atualizar(restaurantId, restaurantAtual);
    }

    private void merge(Map<String, Object> dadosOrigem, Restaurant restaurantDestino) {
        ObjectMapper objectMapper = new ObjectMapper();
        Restaurant restaurantOrigem = objectMapper.convertValue(dadosOrigem, Restaurant.class);

        dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
            Field field = ReflectionUtils.findField(Restaurant.class, nomePropriedade);
            field.setAccessible(true);

            Object novoValor = ReflectionUtils.getField(field, restaurantOrigem);

//			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);

            ReflectionUtils.setField(field, restaurantDestino, novoValor);
        });
    }
}
