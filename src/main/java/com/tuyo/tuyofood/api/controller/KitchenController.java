package com.tuyo.tuyofood.api.controller;

import com.tuyo.tuyofood.domain.entity.Kitchen;
import com.tuyo.tuyofood.domain.repository.KitchenRepository;
import com.tuyo.tuyofood.domain.service.KitchenRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/kitchens")
public class KitchenController {

    @Autowired
    private KitchenRepository kitchenRepository;

    @Autowired
    private KitchenRegisterService kitchenRegisterService;

    /* Listando Coleções de Kitchen */
    @GetMapping
    public List<Kitchen> listar() {
        return kitchenRepository.findAll();
    }

    @GetMapping("/{kitchenId}")
    public Kitchen buscar(@PathVariable Long kitchenId) {
        return kitchenRegisterService.buscarOuFalhar(kitchenId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Kitchen adicionar(@RequestBody Kitchen kitchen) {
        return kitchenRegisterService.salvar(kitchen);
    }

    @PutMapping("/{kitchenId}")
    public Kitchen atualizar(@PathVariable Long kitchenId,
                             @RequestBody Kitchen kitchen) {
        Kitchen kitchenAtual = kitchenRegisterService.buscarOuFalhar(kitchenId);

        BeanUtils.copyProperties(kitchen, kitchenAtual, "id");

        return kitchenRegisterService.salvar(kitchenAtual);
    }

    @DeleteMapping("/{kitchenId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long kitchenId) {
        kitchenRegisterService.excluir(kitchenId);
    }
}
