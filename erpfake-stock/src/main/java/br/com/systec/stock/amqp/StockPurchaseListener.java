package br.com.systec.stock.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.systec.stock.amqp.dto.StockOrderDTO;
import br.com.systec.stock.service.StockService;

@Component
public class StockPurchaseListener {
	private static final Logger LOG = LoggerFactory.getLogger(StockPurchaseListener.class);

	@Autowired
	private StockService stockService;

	@RabbitListener(queues = "stock.queue")
	public void receivePurchaseStock(@Payload StockOrderDTO stockPurchaseDTO) {
		LOG.info("Recenendo o Pedido de compra dos produtos");

		stockService.stockSave(stockPurchaseDTO);
	}
}
