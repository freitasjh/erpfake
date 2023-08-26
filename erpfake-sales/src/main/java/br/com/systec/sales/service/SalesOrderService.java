package br.com.systec.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systec.sales.enums.SalesOrderStatus;
import br.com.systec.sales.model.SalesOrder;
import br.com.systec.sales.repository.SalesOrderRepository;
import jakarta.transaction.Transactional;

@Service
public class SalesOrderService {
	
	@Autowired
	private SalesOrderRepository repository;

	@Transactional
	public SalesOrder save(SalesOrder salesOrder) {
		SalesOrder salesOrderSaved = repository.save(salesOrder);
		
		if(salesOrderSaved.getSalesOrderStatus() == SalesOrderStatus.FINALIZE) {
			//FAZ A LOGICA PARA MANDAR PARA A BAIXA DO STOCK
		}
		
		
		return salesOrderSaved;
	}
	
	@Transactional
	public SalesOrder update(SalesOrder salesOrder) {
		SalesOrder salesOrderSaved = repository.save(salesOrder);
		
		if(salesOrderSaved.getSalesOrderStatus() == SalesOrderStatus.FINALIZE) {
			//FAZ A LOGICA PARA MANDAR PARA A BAIXA DE ESTOQUE
		}
		
		return salesOrderSaved;
	}
	
	@Transactional
	public SalesOrder finalize(Long salesOrderId) {
		SalesOrder salesOrder = repository.findById(salesOrderId).orElseThrow(() -> new RuntimeException("Pedido de venda não encontrado"));
		
		salesOrder.setSalesOrderStatus(SalesOrderStatus.FINALIZE);
		
		SalesOrder salesOrderSaved = repository.save(salesOrder);
		
		//LOGICA PARA MANDAR PARA A BAIXA DE ESTOQUE
		
		return salesOrderSaved;
	}
	
	public List<SalesOrder> findAll() {
		List<SalesOrder> listOfSalesOrder = repository.findAll();
		
		
		return listOfSalesOrder;
	}
	
	public SalesOrder findById(Long salesOrderId) {
		SalesOrder salesOrder = repository.findById(salesOrderId).orElseThrow(() -> new RuntimeException("Pedido de venda não encontrado"));
		
		
		return salesOrder;
	}
	
}
