package br.com.systec.erpfake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "ERP fake client", version = "1.0.0", description = "Sistema erp fake para teste"))
@EnableDiscoveryClient
public class ErpfakeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpfakeClientApplication.class, args);
	}

}
