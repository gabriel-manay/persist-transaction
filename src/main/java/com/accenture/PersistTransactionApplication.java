package com.accenture;

import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import com.accenture.entity.Transaction;
import com.accenture.service.ITransactionService;

@SpringBootApplication
public class PersistTransactionApplication {

	private static final Logger logger = LoggerFactory.getLogger(PersistTransactionApplication.class);
	
	@Autowired
	ITransactionService transactionService;

	public static void main(String[] args) {
		SpringApplication.run(PersistTransactionApplication.class, args);
	}

	@Bean
	public Consumer<Message<Transaction>> persistTransaction() {
		return message -> {
			Transaction transaction = (Transaction) message.getPayload();
			transactionService.save(transaction);
			
			logger.info("Se recibe transaccion: " + transaction.toString());
		};
	}

}
