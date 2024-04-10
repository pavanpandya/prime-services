package edu.iu.pnpandya.primeservice.controller;

import edu.iu.pnpandya.primeservice.service.IAuthenticationService;
import edu.iu.pnpandya.primeservice.model.Customer;
import edu.iu.pnpandya.primeservice.service.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class AuthenticationController {

    private final IAuthenticationService authenticationService;

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    public AuthenticationController(IAuthenticationService authenticationService, AuthenticationManager authenticationManager, TokenService tokenService) {
        this.authenticationService = authenticationService;
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @PostMapping("/register")
    public String register(@RequestBody Customer customer) {
        try {
            return authenticationService.register(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        try {
            if (authenticationService.login(customer.getUsername(), customer.getPassword())) {
                Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword()));
//                return json with token and a success message
                return tokenService.generateToken(authentication);
            }
            // return json with error message
            return "Invalid username or password";
        } catch (Exception e) {
            // return the exception message
            return "Error logging in";
        }
    }

//    @GetMapping("/")
//    public String home() {
//        return "Welcome to the home page!";
//    }
}
