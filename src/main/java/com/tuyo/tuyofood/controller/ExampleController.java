package com.tuyo.tuyofood.controller;

import com.tuyo.tuyofood.modelo.Cliente;
import com.tuyo.tuyofood.service.ativacao.AtivacaoClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*@Controller também transforma esta classe num Bean. Porque a classe Controller também recebe um @Component*/
/*Controlador WEB: informa que é uma classe responsável por receber requisições web*/

/* Processo de Injeção de dependência:*/
/*1ª Apontar primeiro que a classe é um Bean com @Component. Neste caso, o @Controller tem explicação acima*/
@Controller
public class ExampleController {

    /*2ª Injetar o Bean*/
    private AtivacaoClienteService ativacaoClienteService;

    /*3ª Gerando o Construtor*/
    public ExampleController(AtivacaoClienteService ativacaoClienteService) {
        this.ativacaoClienteService = ativacaoClienteService;

        /*Chamando o Construtor como exemplo*/
        System.out.println("ExampleController: " + ativacaoClienteService);
    }

    /*informa o caminho a percorrer*/
    /*ResponseBody: Quero que o retorno, do método hello, cujo retorno é String, seja devolvida como resposta desta requisição */
    /*Hello será devolvida como resposta.*/
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {

        /*4ª Instanciando um objeto joao do tipo Cliente (Bean)*/
        Cliente joao = new Cliente("João", "joao@xyz.com", "3499998888");

        /*5ª Chamando o método Ativar de ativacaoClienteService que
        * é a instância que está sendo injetada pelo Construtor*/
        ativacaoClienteService.ativar(joao);
        return "Olá!";
    }
}

/*
O próprio Spring instancia e injeta onde necessário.
Quando rodamos o projeto, o Spring instanciará na ordem correta devido às dependências:
1º instancia o NotificadorEmail
2º instancia o AtivacaoClienteService ( depois de instanciar, ele tem que passar o NotificadorEmail como parâmetro )
3º instancia o ExampleController ( depois de instanciar, ele tem que passar o AtivacaoClienteService como parâmetro )
4º Resposta no console: Notificando João através do e-mail joao@xyz.com: Seu cadastro no sistema está ativo!
*/
