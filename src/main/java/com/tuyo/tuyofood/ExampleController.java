package com.tuyo.tuyofood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello!";
    }

}