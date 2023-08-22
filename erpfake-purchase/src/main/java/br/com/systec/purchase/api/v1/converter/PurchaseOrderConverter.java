package br.com.systec.purchase.api.v1.converter;

import java.util.ArrayList;

import br.com.systec.purchase.api.v1.dto.PurchaseItemDTO;
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
}
