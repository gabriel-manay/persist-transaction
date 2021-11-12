package com.accenture;

import java.util.function.Consumer;

import entity.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import service.ITransacService;

@SpringBootApplication
public class PersistTransactionApplication {

	@Autowired
	ITransacService transacService;

	private static final Logger logger = LoggerFactory.getLogger(PersistTransactionApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PersistTransactionApplication.class, args);
	}

	@Bean
	public Consumer<Message<Transaction>> persistTransaction() {


		return message -> {
			Transaction transaction=message.getPayload();
			transacService.save(transaction);
			logger.info("Se recibe transaccion: " + message.getPayload());
		};
	}
	
}
