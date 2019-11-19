package api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication(scanBasePackages = "com.dreamteam.parkshark")
public class ParkSharkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkSharkApplication.class, args);
    }

}
