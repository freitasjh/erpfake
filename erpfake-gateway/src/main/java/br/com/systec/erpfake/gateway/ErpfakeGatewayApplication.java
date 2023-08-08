package br.com.systec.erpfake.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class ErpfakeGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErpfakeGatewayApplication.class, args);
	}
	

	@Bean
	RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route(r -> r.path("/client/v3/api-docs").and().method(HttpMethod.GET).uri("lb://client"))
				.route(r -> r.path("/api/v1/clients").and().method(HttpMethod.GET).uri("lb://client"))
				.route(r -> r.path("/api/v1/clients").and().method(HttpMethod.POST).uri("lb://client"))
				.route(r -> r.path("/api/v1/clients").and().method(HttpMethod.PUT).uri("lb://client"))
				.route(r -> r.path("/product/v3/api-docs").and().method(HttpMethod.GET).uri("lb://product"))
				.route(r -> r.path("/api/v1/products").and().method(HttpMethod.GET).uri("lb://product"))
				.route(r -> r.path("/api/v1/products").and().method(HttpMethod.POST).uri("lb://product"))
				.route(r -> r.path("/api/v1/stocks/productQuantity").and().method(HttpMethod.GET).uri("lb://stock"))
				.build();
	}

}
