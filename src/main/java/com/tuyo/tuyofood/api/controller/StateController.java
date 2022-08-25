package com.tuyo.tuyofood.api.controller;

import com.tuyo.tuyofood.domain.entity.State;
import com.tuyo.tuyofood.domain.repository.StateRepository;
import com.tuyo.tuyofood.domain.service.StateRegisterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private StateRegisterService stateRegisterService;

    @GetMapping
    public List<State> listar() {
        return stateRepository.findAll();
    }

    @GetMapping("/{stateId}")
    public State buscar(@PathVariable Long stateId) {
        return stateRegisterService.buscarOuFalhar(stateId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public State adicionar(@RequestBody State state) {
        return stateRegisterService.salvar(state);
    }

    @PutMapping("/{stateId}")
    public State atualizar(@PathVariable Long stateId,
                            @RequestBody State state) {
        State stateAtual = stateRegisterService.buscarOuFalhar(stateId);

        BeanUtils.copyProperties(state, stateAtual, "id");

        return stateRegisterService.salvar(stateAtual);
    }

    @DeleteMapping("/{stateId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long stateId) {
        stateRegisterService.excluir(stateId);
    }
}
