package com.emmanuel.plumas.p12JavaVegetAbleBATCH;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.emmanuel.plumas.p12JavaVegetAbleBATCH.tasks.UserPasswordCryptation;

@EnableScheduling
@SpringBootApplication
@EnableFeignClients("com.emmanuel.plumas.p12JavaVegetAbleBATCH.proxies")
public class P12JavaVegetAbleBatchApplication {

	@Autowired
	@Qualifier("UserPasswordCryptation")
	private UserPasswordCryptation userPasswordCryptation;
	
	public static void main(String[] args) {
		SpringApplication.run(P12JavaVegetAbleBatchApplication.class, args);		
	}
	
	@Scheduled(fixedDelay=10000)
	public void run() {
		System.out.println("lancement du chiffrement");
		userPasswordCryptation.execute();
	}
}
