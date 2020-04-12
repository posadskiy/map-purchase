package com.posadskiy.mappurchase;

import com.posadskiy.mappurchase.db.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapPurchaseApplication implements CommandLineRunner {
	@Autowired
	UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(MapPurchaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.findAll();
	}
}
