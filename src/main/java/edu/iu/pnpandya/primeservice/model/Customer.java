package edu.iu.pnpandya.primeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Table
@Entity
public class Customer {
    @Id
    private String username;
    private String password;

    public Customer (){

    }

    public Customer(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){ return username;}
    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){ return password;}
    public void setPassword(String password){
        this.password = password;
    }
}
