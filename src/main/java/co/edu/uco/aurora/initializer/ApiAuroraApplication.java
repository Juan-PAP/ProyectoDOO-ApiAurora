package co.edu.uco.aurora.initializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "co.edu.uco.aurora")
public class ApiAuroraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAuroraApplication.class, args);
	}

}
