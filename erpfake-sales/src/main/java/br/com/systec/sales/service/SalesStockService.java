package br.com.systec.sales.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systec.sales.amqp.SalesAMQPConfiguration;
import br.com.systec.sales.amqp.dto.StockOrderDTO;
import br.com.systec.sales.amqp.dto.StockOrderItemDTO;
import br.com.systec.sales.model.SalesOrder;
import br.com.systec.sales.model.SalesOrderItem;

@Service
public class SalesStockService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void sendSalesStock(SalesOrder salesOrder) {
		StockOrderDTO salesStock = new StockOrderDTO();
		salesStock.setOrderId(salesOrder.getId());
		
		List<StockOrderItemDTO> listOfSalesStockItem = new ArrayList<>();
		
		for(SalesOrderItem item : salesOrder.getListOfSalesOrderItem()) {
			StockOrderItemDTO itemDTO = new StockOrderItemDTO();
			itemDTO.setProductId(item.getProductId());
			itemDTO.setQuantity(item.getQuantity());
			
			listOfSalesStockItem.add(itemDTO);
		}
		
		salesStock.setListOfSalesOrderItem(listOfSalesStockItem);
		
		rabbitTemplate.convertAndSend(SalesAMQPConfiguration.STOCK_EX, salesStock);
	}
}
