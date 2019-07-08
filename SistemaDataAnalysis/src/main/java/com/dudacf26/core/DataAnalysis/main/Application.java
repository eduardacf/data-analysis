package com.dudacf26.core.DataAnalysis.main;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ComponentScan({"com.dudacf26.core.DataAnalysis"})
@EnableScheduling
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		System.out.println("Analise de Dados Iniciada!");
	    SpringApplication.run(Application.class, args);
	}
}

