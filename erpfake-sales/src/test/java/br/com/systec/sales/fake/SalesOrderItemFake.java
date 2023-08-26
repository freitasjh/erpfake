package br.com.systec.sales.fake;

import br.com.systec.sales.api.v1.dto.SalesOrderItemDTO;
import br.com.systec.sales.model.SalesOrderItem;

public class SalesOrderItemFake {

	public static SalesOrderItem toFake() {
		SalesOrderItem salesOrderItem = new SalesOrderItem();
		salesOrderItem.setId(1L);
		salesOrderItem.setProductId(20L);
		salesOrderItem.setProductDescription("Produto teste");
		salesOrderItem.setQuantity(10);
		salesOrderItem.setSubTotal(50);
		salesOrderItem.setDiscountPercent(0);
		salesOrderItem.setDiscountValue(0);
		salesOrderItem.setUnitValue(5);
		salesOrderItem.setAmount(50);

		return salesOrderItem;
	}
	
	public static SalesOrderItemDTO toFakeDTO() {
		SalesOrderItemDTO salesOrderItem = new SalesOrderItemDTO();
		salesOrderItem.setId(1L);
		salesOrderItem.setProductId(20L);
		salesOrderItem.setProductDescription("Produto teste");
		salesOrderItem.setQuantity(10);
		salesOrderItem.setSubTotal(50);
		salesOrderItem.setDiscountPercent(0);
		salesOrderItem.setDiscountValue(0);
		salesOrderItem.setUnitValue(5);
		salesOrderItem.setAmount(50);

		return salesOrderItem;
	}
}
