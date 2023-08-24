package br.com.systec.purchase.amqp;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PurchaseAMQPConfiguration {

	public static final String STOCK_PUSH_QUEUE = "stock.purchase";
	public static final String STOCK_PUSH_FANOUT = "stock.purchase.ex";

//	@Bean
//	Queue stockQueue() {
//		return QueueBuilder.nonDurable(STOCK_PUSH_QUEUE).build();
//	}

	@Bean
	RabbitAdmin createRabbitAdmin(ConnectionFactory conection) {
		return new RabbitAdmin(conection);
	}

	@Bean
	ApplicationListener<ApplicationReadyEvent> initializeAdmin(RabbitAdmin rabbitAdmin) {
		return event -> rabbitAdmin.initialize();
	}

	@Bean
	Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
	FanoutExchange createFanoutExchange() {
		return new FanoutExchange(STOCK_PUSH_FANOUT);
	}

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);

		return rabbitTemplate;
	}
}
