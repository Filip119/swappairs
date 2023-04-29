package sk.fzdp.ciphers.swappairs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="sk.fzdp.ciphers.swappairs")
public class SwappairsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwappairsApplication.class, args);
	}

}
