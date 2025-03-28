package com.example.ludotehque;

import com.example.ludotehque.bll.UserAppService;
import com.example.ludotehque.enumeration.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LudotehqueApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LudotehqueApplication.class, args);
	}

	@Autowired
	private UserAppService userAppService;

	@Override
	public void run(String... args) throws Exception {
		userAppService.createUser("employe", "pa$$WORD-", Role.EMPLOYE.toString());
		userAppService.createUser("admin", "Pa$$w0rd+", Role.ADMIN+","+Role.EMPLOYE);
	}
}
