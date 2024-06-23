package io.pismo.transactionAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class TransactionApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApiApplication.class, args);
	}

}
