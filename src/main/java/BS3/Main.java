package BS3;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @PostConstruct
    public void first() {
        System.out.println("Hola soy la clase inicial");
    }

    @Bean
    CommandLineRunner second() {
        return a -> System.out.println("Hola soy la segunda clase");
    }

    @Bean
    CommandLineRunner third(ApplicationArguments args) {
        return a -> {
            System.out.println("Soy la tercera clase");
            System.out.println("Argument "+ Arrays.toString(args.getSourceArgs()));
        };
    }
}