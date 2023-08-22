package br.com.systec.purchase.fake;

import br.com.systec.purchase.api.v1.dto.PurchaseItemDTO;
import br.com.systec.purchase.model.PurchaseItem;

public class PurchaseItemFake {
	
	
	public static PurchaseItem toFakeItem() {
		PurchaseItem purchaseItem = new PurchaseItem();
		
		purchaseItem.setId(1L);
		purchaseItem.setProductId(1L);
		purchaseItem.setProductDescription("Produto teste");
		purchaseItem.setQuantity(10);
		purchaseItem.setUnitaryValue(5.0);
		purchaseItem.setAmount(50);
		
		return purchaseItem;
	}
	
	public static PurchaseItemDTO toFakeItemDTO() {
		PurchaseItemDTO purchaseItem = new PurchaseItemDTO();
		
		purchaseItem.setId(1L);
		purchaseItem.setProductId(1L);
		purchaseItem.setProductDescription("Produto teste");
		purchaseItem.setQuantity(10);
		purchaseItem.setUnitaryValue(5.0);
		purchaseItem.setAmount(50);
		
		return purchaseItem;
	}
}
