package edu.iu.pnpandya.primeservice.service;

import edu.iu.pnpandya.primeservice.model.Customer;

import java.io.IOException;

public interface IAuthenticationService {
    String register(Customer customer) throws Exception;
    boolean login(String username, String password) throws Exception;
}
