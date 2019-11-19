package com.dreamteam.parkshark.api.controllers;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.dreamteam.parkshark")
@EnableJpaRepositories(basePackages = "com.dreamteam.parkshark.repository")
@EntityScan(basePackages = "com.dreamteam.parkshark.domain")
public class TestApplication {

}
