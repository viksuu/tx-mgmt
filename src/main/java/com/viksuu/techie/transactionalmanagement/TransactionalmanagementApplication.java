package com.viksuu.techie.transactionalmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalmanagementApplication.class, args); 
	}

}

