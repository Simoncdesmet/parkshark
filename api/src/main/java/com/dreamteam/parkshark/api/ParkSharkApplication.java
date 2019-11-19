package com.dreamteam.parkshark.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dreamteam.parkshark")
public class ParkSharkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkSharkApplication.class, args);
    }

}
