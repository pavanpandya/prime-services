package edu.iu.pnpandya.primeservice.controller;

import edu.iu.pnpandya.primeservice.service.IPrimesService;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    IPrimesService primesService;


    public PrimesController(IPrimesService primesService) {
        this.primesService = primesService;
    }

    @GetMapping("/{n}")
    public boolean isPrime(@PathVariable long n) {
        return primesService.isPrime(n);
    }
}