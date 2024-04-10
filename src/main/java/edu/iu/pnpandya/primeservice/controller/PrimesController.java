package edu.iu.pnpandya.primeservice.controller;

import edu.iu.pnpandya.primeservice.rabbitmq.MQSender;
import edu.iu.pnpandya.primeservice.service.IPrimesService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.iu.pnpandya.primeservice.rabbitmq.MQSender;


//@RestController
//@CrossOrigin
//@RequestMapping("/primes")
//public class PrimesController {
//    @Autowired
//    IPrimesService primesService;
//
//    public PrimesController(IPrimesService primesService){
//        this.primesService = primesService;
//    }
//
//    @GetMapping("/{n}")
//    public boolean isPrime(@PathVariable int n){
//        return primesService.isPrime(n);
//    }
//
//    @GetMapping("/error")
//    public String error(){
//        return "error";
//    }
//}


@RestController
@CrossOrigin
@RequestMapping("/primes")
public class PrimesController {

    @Autowired
    IPrimesService primesService;

    private final MQSender mqSender;

    public PrimesController(IPrimesService primesService, MQSender mqSender) {
        this.primesService = primesService;
        this.mqSender = mqSender;
    }

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable long n) {
        boolean result =  primesService.isPrime(n);
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username =  ((Jwt) principal ).getSubject();
        mqSender.sendMessage(username, n, result);
        return result;
    }


}