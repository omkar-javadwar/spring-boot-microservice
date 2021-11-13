package com.cropdeal.crop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@EnableEurekaClient
@OpenAPIDefinition(info=@Info(title = "Crop API", version = "1.0", description = "crop service"))
@SpringBootApplication
public class CropApplication {

	public static void main(String[] args) {
		SpringApplication.run(CropApplication.class, args);
	}
}
