package edu.iu.pnpandya.primeservice.repository;

import edu.iu.pnpandya.primeservice.model.Customer;

import java.io.IOException;

public interface IAuthenticationRepository {
    boolean save(Customer customer) throws IOException;
    Customer findByUsername(String username) throws IOException;
//    Customer register(Customer customer) throws IOException;
//    boolean login(String username, String password) throws IOException;
}
