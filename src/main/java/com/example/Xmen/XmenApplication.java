package com.example.Xmen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com/example/Xmen/entities")
@SpringBootApplication
public class XmenApplication {

	private static final Logger logger = LoggerFactory.getLogger(XmenApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(XmenApplication.class, args);
		logger.info("La aplicación Xmen está funcionando correctamente");
	}
}
