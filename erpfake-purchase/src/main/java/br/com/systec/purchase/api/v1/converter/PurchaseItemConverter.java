package br.com.systec.purchase.api.v1.converter;

import br.com.systec.purchase.api.v1.dto.PurchaseItemDTO;
import br.com.systec.purchase.model.PurchaseItem;

public class PurchaseItemConverter {

	private static PurchaseItemConverter instance;
	
	public static PurchaseItemConverter getInstance() {
		if(instance == null) {
			instance = new PurchaseItemConverter();
		}
		
		return instance;
	}
	
	private PurchaseItemConverter() {}
	
	
	public PurchaseItem toEntity(PurchaseItemDTO itemDTO) {
		PurchaseItem purchaseItem = new PurchaseItem();
		purchaseItem.setId(itemDTO.getId());
		purchaseItem.setProductId(itemDTO.getProductId());
		purchaseItem.setProductDescription(itemDTO.getProductDescription());
		purchaseItem.setQuantity(itemDTO.getQuantity());
		purchaseItem.setAmount(itemDTO.getAmount());
		purchaseItem.setUnitaryValue(itemDTO.getUnitaryValue());
		
		return purchaseItem;
	}
	
	public PurchaseItemDTO toDTO(PurchaseItem purchaseItem) {
		PurchaseItemDTO itemDTO = new PurchaseItemDTO();
		itemDTO.setId(purchaseItem.getId());
		itemDTO.setProductId(purchaseItem.getProductId());
		itemDTO.setProductDescription(purchaseItem.getProductDescription());
		itemDTO.setQuantity(purchaseItem.getQuantity());
		itemDTO.setAmount(purchaseItem.getAmount());
		itemDTO.setUnitaryValue(purchaseItem.getUnitaryValue());
		
		return itemDTO;
	}
}
