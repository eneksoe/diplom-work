package com.bta.diplom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication/*(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
)*/
public class DiplomApplication {


    public static void main(String[] args) {

        SpringApplication.run(DiplomApplication.class, args);
    }
}
