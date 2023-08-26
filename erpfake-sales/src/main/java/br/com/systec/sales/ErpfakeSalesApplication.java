package br.com.systec.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ERP fake Venda", version = "1.0.0", description = "Microservico de venda"))
@EnableDiscoveryClient
public class ErpfakeSalesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpfakeSalesApplication.class, args);
	}

}
