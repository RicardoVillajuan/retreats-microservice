package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@SpringBootApplication
public class RetreatsMicroserviceApplication {
    /**
     * Funcion Main.
     * @param args
     */
    public static void main(final String[] args) {
        SpringApplication
        .run(RetreatsMicroserviceApplication.class, args); 
    }
}
