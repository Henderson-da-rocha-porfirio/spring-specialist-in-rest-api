package com.tuyo.tuyofood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller                             /*informa que é uma classe responsável por receber requisições web*/
public class ExampleController {

    @GetMapping("/hello")               /*informa o caminho a percorrer*/
    @ResponseBody                       /*Quero que o retorno, do método hello, cujo retorno é String, seja devolvida como resposta desta requisição */
    public String hello() {
        return "Hello!";                /*Hello será devolvida como resposta.*/
    }

}