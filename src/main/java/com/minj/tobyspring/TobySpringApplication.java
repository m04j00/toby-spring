package com.minj.tobyspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class TobySpringApplication {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(TobySpringApplication.class, args);
    }

}
