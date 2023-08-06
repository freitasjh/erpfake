package br.com.systec.erpfake.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ERP fake product", version = "1.0.0", description = "Sistema erp fake para teste"))
@EnableDiscoveryClient
@EnableFeignClients
public class ErpfakeProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpfakeProductApplication.class, args);
	}

}
