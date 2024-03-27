package edu.iu.pnpandya.primeservice.controller;

import edu.iu.pnpandya.primeservice.service.IAuthenticationService;
import edu.iu.pnpandya.primeservice.model.Customer;
import java.io.IOException;

import edu.iu.pnpandya.primeservice.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final IAuthenticationService authenticationService;
    private final AuthenticationManager authenticationManager;

    private TokenService tokenService;

    public AuthenticationController(IAuthenticationService authenticationService,
                                    AuthenticationManager authenticationManager,
                                    TokenService tokenService){
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer){
        try {
            return authenticationService.register(customer);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(customer.getUsername(),
                        customer.getPassword()));
//        return "Success!";
        return tokenService.generateToken(authentication);
    }
}

