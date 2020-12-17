package br.com.iti.validationpassword;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"br.com.iti.validationpassword.*"})
public class ValidationPasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValidationPasswordApplication.class, args);
	}

}
