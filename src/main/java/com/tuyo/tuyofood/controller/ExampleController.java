package com.tuyo.tuyofood.controller;

import com.tuyo.tuyofood.modelo.Cliente;
import com.tuyo.tuyofood.service.ativacao.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {

    private AtivacaoClienteService ativacaoClienteService;

    public ExampleController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {


        Cliente joao = new Cliente("João", "joao@xyz.com", "3499998888");
        ativacaoClienteService.ativar(joao);
        return "Olá!";
    }
}