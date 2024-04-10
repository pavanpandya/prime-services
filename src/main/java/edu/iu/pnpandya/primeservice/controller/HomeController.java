package edu.iu.pnpandya.primeservice.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HomeController {
    @GetMapping("/")
    public String greetings(){
        return "Welcome to the prime services!";
    }

    @GetMapping("/error")
    public String error(){
        return "Error";
    }
}
