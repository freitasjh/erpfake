package br.com.systec.purchase.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systec.purchase.enums.OrderStatus;
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
	
	@Transactional
	public PurchaseOrder save(PurchaseOrder purchaseOrder) {
		PurchaseOrder purchaseOrderSaved = repository.save(purchaseOrder);
		
		if(purchaseOrder.getOrderStatus() == OrderStatus.FINSH) {
			//LOGICA PARA SALVAR O ESTOQUE....
		}
		
		return purchaseOrderSaved;
	}
	
	@Transactional
	public PurchaseOrder finalizePurchaseOrder(Long purchaseOrderId, boolean finalize) {
		PurchaseOrder purchaseOrder = repository.findById(purchaseOrderId).orElseThrow(() -> new RuntimeException("Compra não encontrada"));
		
		purchaseOrder.setOrderStatus(OrderStatus.FINSH);
		
		//LOGICA PARA SALVAR NO ESTOQUE...
		
		return repository.save(purchaseOrder);
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
}
