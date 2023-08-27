package br.com.systec.purchase.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systec.purchase.amqp.PurchaseAMQPConfiguration;
import br.com.systec.purchase.amqp.dto.StockOrderDTO;
import br.com.systec.purchase.amqp.dto.StockOrderItemDTO;
import br.com.systec.purchase.enums.OrderStatus;
import br.com.systec.purchase.model.PurchaseItem;
import br.com.systec.purchase.model.PurchaseOrder;
import br.com.systec.purchase.repository.PurchaseOrderRepository;
import jakarta.transaction.Transactional;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@Service
public class PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepository repository;
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Transactional
	public PurchaseOrder save(PurchaseOrder purchaseOrder) {
		PurchaseOrder purchaseOrderSaved = repository.save(purchaseOrder);
		
		if(purchaseOrder.getOrderStatus() == OrderStatus.FINSH) {
			sendStockPurchase(purchaseOrderSaved);
		}
		
		return purchaseOrderSaved;
	}
	
	@Transactional
	public PurchaseOrder finalizePurchaseOrder(Long purchaseOrderId) {
		PurchaseOrder purchaseOrder = repository.findById(purchaseOrderId).orElseThrow(() -> new RuntimeException("Compra não encontrada"));
		
		purchaseOrder.setOrderStatus(OrderStatus.FINSH);
		
		PurchaseOrder purchaseOrderSaved = repository.save(purchaseOrder);
		
		sendStockPurchase(purchaseOrderSaved);
		
		return purchaseOrderSaved;
	}
	
	public List<PurchaseOrder> findAll() {
		List<PurchaseOrder> listOfPurchaseOrder = new ArrayList<>();
		
		listOfPurchaseOrder = repository.findAll();
		
		return listOfPurchaseOrder;
	}
	
	public List<PurchaseOrder> findByFilterOrder(OrderStatus orderStatus) {
		List<PurchaseOrder> listOfPurchaseOrder = repository.findByOrderStatus(orderStatus);
		
		return listOfPurchaseOrder;
	}
	
	private void sendStockPurchase(PurchaseOrder purchaseOrder) {
		StockOrderDTO stockPurchaseDTO = new StockOrderDTO();
		stockPurchaseDTO.setOrderId(purchaseOrder.getId());
		stockPurchaseDTO.setDateOrderFinalize(new Date());
		
		for(PurchaseItem item : purchaseOrder.getListOfPurchaseItem()) {
			StockOrderItemDTO itemDTO = new StockOrderItemDTO();
			itemDTO.setProductId(item.getProductId());
			itemDTO.setQuantity(item.getQuantity());
			stockPurchaseDTO.getListOfSalesOrderItem().add(itemDTO);
		}
		
		
		rabbitTemplate.convertAndSend(PurchaseAMQPConfiguration.STOCK_EXANGE, stockPurchaseDTO);
	}
}
