package br.com.systec.purchase.fake;

import java.util.Arrays;

import br.com.systec.purchase.enums.OrderStatus;
import br.com.systec.purchase.model.PurchaseOrder;

public class PurchaseOrderFake {
	
	public static PurchaseOrder toFake() {
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		purchaseOrder.setId(1L);
		purchaseOrder.setCode("1");
		purchaseOrder.setOrderStatus(OrderStatus.OPEN);
		purchaseOrder.setQuantity(10);
		purchaseOrder.setAmount(50);
		purchaseOrder.setListOfPurchaseItem(Arrays.asList(PurchaseItemFake.toFakeItem()));
		
		return purchaseOrder;
	}
}
