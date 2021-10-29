package com.accenture;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

@SpringBootApplication
public class PersistTransactionApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(PersistTransactionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PersistTransactionApplication.class, args);
	}

	@Bean
	public Consumer<Message<String>> persistTransaction() {
		
		return message ->
			logger.info("Se recibe transaccion: " + message.getPayload());
	}
	
}
