package com.emmanuel.plumas.p12JavaVegetAbleWEB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.emmanuel.plumas.p12JavaVegetAbleWEB.proxies")
public class P12JavaVegetAbleWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(P12JavaVegetAbleWebApplication.class, args);
	}

}
