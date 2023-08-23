package br.com.systec.purchase.api.v1.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.systec.purchase.api.v1.dto.PurchaseItemDTO;
import br.com.systec.purchase.api.v1.dto.PurchaseOrderDTO;
import br.com.systec.purchase.api.v1.dto.PurchaseOrderInputDTO;
import br.com.systec.purchase.model.PurchaseItem;
import br.com.systec.purchase.model.PurchaseOrder;

public class PurchaseOrderConverter {
	private static PurchaseOrderConverter instance;
	
	public static PurchaseOrderConverter getInstance() {
		if (instance == null) {
			instance = new PurchaseOrderConverter();
		}
		
		return instance;
	}
	
	private PurchaseOrderConverter() {
		
	}
	
	public PurchaseOrder toEntity(PurchaseOrderInputDTO inputDTO) {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		
		purchaseOrder.setId(inputDTO.getId());
		purchaseOrder.setCode(inputDTO.getCode());
		purchaseOrder.setAmount(inputDTO.getAmount());
		purchaseOrder.setQuantity(inputDTO.getQuantity());
		purchaseOrder.setSubTotal(inputDTO.getSubtotal());
		purchaseOrder.setOrderStatus(inputDTO.getOrderStatus());
		
		if(inputDTO.getListOfPurchaseItem() != null && !inputDTO.getListOfPurchaseItem().isEmpty()) {
			purchaseOrder.setListOfPurchaseItem(new ArrayList<>());
			
			for(PurchaseItemDTO item : inputDTO.getListOfPurchaseItem()) {
				PurchaseItem purchaseItem = PurchaseItemConverter.getInstance().toEntity(item);
				purchaseItem.setPurchaseOrder(purchaseOrder);
				purchaseOrder.getListOfPurchaseItem().add(purchaseItem);
			}
		}
		
		return purchaseOrder;
	}	
	
	
	public PurchaseOrderInputDTO toInputDTO(PurchaseOrder purchaseOrder) {
		PurchaseOrderInputDTO inputDTO = new PurchaseOrderInputDTO();
		inputDTO.setId(purchaseOrder.getId());
		inputDTO.setCode(purchaseOrder.getCode());
		inputDTO.setOrderStatus(purchaseOrder.getOrderStatus());
		inputDTO.setQuantity(purchaseOrder.getQuantity());
		inputDTO.setSubtotal(purchaseOrder.getSubTotal());
		inputDTO.setAmount(purchaseOrder.getAmount());
		
		if(!purchaseOrder.getListOfPurchaseItem().isEmpty()) {
			inputDTO.setListOfPurchaseItem(new ArrayList<>());
			for(PurchaseItem item : purchaseOrder.getListOfPurchaseItem()) {
				inputDTO.getListOfPurchaseItem().add(PurchaseItemConverter.getInstance().toDTO(item));
			}
		}
		
		return inputDTO;
	}
	
	
	public PurchaseOrderDTO toDTO(PurchaseOrder purchaseOrder) {
		PurchaseOrderDTO purchaseOrderDTO = new PurchaseOrderDTO();
		purchaseOrderDTO.setId(purchaseOrder.getId());
		purchaseOrderDTO.setAmmount(purchaseOrder.getAmount());
		purchaseOrderDTO.setQuantity(purchaseOrder.getQuantity());
		purchaseOrderDTO.setCode(purchaseOrder.getCode());
		purchaseOrderDTO.setOrderStatus(purchaseOrder.getOrderStatus());
		
		return purchaseOrderDTO;
	}
	
	
	public List<PurchaseOrderDTO> toListDTO(List<PurchaseOrder> listOfPurchaseOrder) {
		if(listOfPurchaseOrder == null || listOfPurchaseOrder.isEmpty()) {
			return new ArrayList<>();
		}
		
		return listOfPurchaseOrder.stream().map(this::toDTO).toList();
	}
}
