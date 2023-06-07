package com.salesianostriana.dam.cinejava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CineJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineJavaApplication.class, args);
		
		int num=13,num2=6;
		
		System.out.println(num/num2);
		
	}

}
