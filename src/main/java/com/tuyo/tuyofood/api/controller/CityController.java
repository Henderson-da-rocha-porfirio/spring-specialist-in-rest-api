package com.tuyo.tuyofood.api.controller;


import com.tuyo.tuyofood.domain.entity.City;
import com.tuyo.tuyofood.domain.exception.BusinessException;
import com.tuyo.tuyofood.domain.exception.EntidadeNaoEncontradaException;
import com.tuyo.tuyofood.domain.repository.CityRepository;
import com.tuyo.tuyofood.domain.service.CityRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return cityRegisterService.salvar(city);
    }

    @PutMapping("/{cityId}")
    public City atualizar(@PathVariable Long cityId,
                          @RequestBody City city) {
        City cityAtual = cityRegisterService.buscarOuFalhar(cityId);

        BeanUtils.copyProperties(city, cityAtual, "id");

        try {
            return cityRegisterService.salvar(cityAtual);
        } catch (EntidadeNaoEncontradaException e) {
            throw new BusinessException(e.getMessage());
        }

    }

    @DeleteMapping("/{cityId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cityId) {
        cityRegisterService.excluir(cityId);
    }
}
