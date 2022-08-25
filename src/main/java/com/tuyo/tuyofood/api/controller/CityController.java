package com.tuyo.tuyofood.api.controller;


import com.tuyo.tuyofood.domain.entity.City;
import com.tuyo.tuyofood.domain.exception.BusinessException;
import com.tuyo.tuyofood.domain.exception.StateNaoEncontradoException;
import com.tuyo.tuyofood.domain.repository.CityRepository;
import com.tuyo.tuyofood.domain.service.CityRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/* 1. Exception Granular: É melhor trabalhar na camada de domínio, exceptions com granularidade
 * mais fina (exceptions mais específicas)
 *  2. Importante: não deixar buscarOuFalhar e salvar dentro do try porque dará erro. Cada método tem sua tratativa
 * específica. Mas no caso de ter uma exception específica, não tem problema como mostrado abaixo.
 *  3. Rastreabilidade de Exception = mensagem e causa: BusinessException(e.getMessage(), e):
 * a. BusinessException(e.getMessage()): mensagem.
 * b. BusinessException(e.getMessage(), e), o 'e' é causa.
 * c. é preciso criar a causa na exception correspondente: BusinessException. */

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityRegisterService cityRegisterService;

    @GetMapping
    public List<City> listar() {
        return cityRepository.findAll();
    }


    @GetMapping("/{cityId}")
    public City buscar(@PathVariable Long cityId) {
        return cityRegisterService.buscarOuFalhar(cityId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public City adicionar(@RequestBody City city) {
        try {
            return cityRegisterService.salvar(city);
        } catch (StateNaoEncontradoException e) {
            throw new BusinessException(e.getMessage(), e);
        }
    }

    @PutMapping("/{cityId}")
    public City atualizar(@PathVariable Long cityId,
                          @RequestBody City city) {
        try {
            City cityAtual = cityRegisterService.buscarOuFalhar(cityId);

            BeanUtils.copyProperties(city, cityAtual, "id");

            return cityRegisterService.salvar(cityAtual);
        } catch (StateNaoEncontradoException e) {
            throw new BusinessException(e.getMessage(), e);
        }

    }

    @DeleteMapping("/{cityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cityId) {
        cityRegisterService.excluir(cityId);
    }
}
