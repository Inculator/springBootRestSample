package com.mg.restController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RestApplicationLauncher {

    public static void main(String[] args) {
        SpringApplication.run(RestApplicationLauncher.class, args);
    }
}
