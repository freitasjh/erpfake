package br.com.systec.purchase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "API Compra", version = "1.0", description = "Documentation API Compra v1.0"))
public class ErpfakePurchaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpfakePurchaseApplication.class, args);
	}

}
