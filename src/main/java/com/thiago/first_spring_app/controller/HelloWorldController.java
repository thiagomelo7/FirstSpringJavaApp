package com.thiago.first_spring_app.controller;


import com.thiago.first_spring_app.domain.User;
import com.thiago.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;


    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
        //Esquerda= variavel instanciada na private
        //Direita= variavel instanciada no construtor
    }

    @GetMapping
    public String helloWorld() {
        return helloWorldService.helloWorld("Thiago");
    }

    @PostMapping("/{id}")
    public String helloWorldPost(@PathVariable("id") String id,@RequestBody User body) {
        return "Hello World Post " + body.getName() + id;
    }
}
