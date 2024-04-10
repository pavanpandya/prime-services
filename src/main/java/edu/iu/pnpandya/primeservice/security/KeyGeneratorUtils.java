package edu.iu.pnpandya.primeservice.security;

import org.springframework.stereotype.Component;
import java.security.KeyPair;
import java.security.KeyPairGenerator;

@Component
public class KeyGeneratorUtils {
    private  KeyGeneratorUtils(){}

    static KeyPair generateKeyPair(){
        KeyPair keyPair;
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
        return keyPair;
    }
}
