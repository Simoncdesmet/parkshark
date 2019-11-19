package com.dreamteam.parkshark.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.dreamteam.parkshark")
@EnableJpaRepositories(basePackages = "com.dreamteam.parkshark.repository")
public class Application {

    public static void main(String[] args) {
    }
}
