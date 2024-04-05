package edu.iu.pnpandya.primeservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import edu.iu.pnpandya.primeservice.model.Customer;

@Repository
public interface AuthenticationDBRepository extends CrudRepository<Customer, String> {

    Customer findByUsername(String username);

}