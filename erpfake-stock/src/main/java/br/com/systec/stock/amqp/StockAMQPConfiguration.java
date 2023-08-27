package br.com.systec.stock.amqp;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockAMQPConfiguration {

	public static final String STOCK_PUSH_QUEUE = "stock.queue";
	public static final String STOCK_PUSH_QUEUE_DLQ = "stock.dlq";
	public static final String STOCK_PUSH_FANOUT = "stock.ex";
	public static final String STOCK_PUSH_FANOUT_dlx = "stock.dlx";

	@Bean
	Jackson2JsonMessageConverter messageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter) {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);

		return rabbitTemplate;
	}

	
	@Bean
	FanoutExchange fanoutExchange() {
		return ExchangeBuilder.fanoutExchange(STOCK_PUSH_FANOUT).build();
	}

	@Bean
	FanoutExchange fanoutExchangeDLX() {
		return ExchangeBuilder.fanoutExchange(STOCK_PUSH_FANOUT_dlx).build();
	} 

	@Bean
	Queue queueStockPushDLQ() {
		return QueueBuilder.nonDurable(STOCK_PUSH_QUEUE_DLQ).build();
	}
	
	@Bean
	Queue queueStockPush() {
		return QueueBuilder.nonDurable(STOCK_PUSH_QUEUE).deadLetterExchange(STOCK_PUSH_FANOUT_dlx).build();
	}
	
	@Bean
	Binding createBindStockPurchase() {
		return BindingBuilder.bind(queueStockPush()).to(fanoutExchange());
	}

	@Bean
	Binding bindingStockDQlStockDLX() {
		return BindingBuilder.bind(queueStockPushDLQ()).to(fanoutExchangeDLX());
	}
}
