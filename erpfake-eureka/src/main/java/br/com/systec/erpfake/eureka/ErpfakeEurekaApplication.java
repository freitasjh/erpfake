package br.com.systec.erpfake.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ErpfakeEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpfakeEurekaApplication.class, args);
	}

}
