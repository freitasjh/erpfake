package br.com.systec.sales.fake;

import java.util.ArrayList;

import br.com.systec.sales.api.v1.dto.SalesOrderInputDTO;
import br.com.systec.sales.api.v1.dto.SalesOrderItemDTO;
import br.com.systec.sales.enums.SalesOrderStatus;
import br.com.systec.sales.model.SalesOrder;
import br.com.systec.sales.model.SalesOrderItem;

public class SalesOrderFake {

	public static SalesOrder toFake() {
		SalesOrder salesOrder = new SalesOrder();
		salesOrder.setId(1L);
		salesOrder.setClientId(1L);
		salesOrder.setClientName("Cliente teste");
		salesOrder.setQuantityTotal(10);
		salesOrder.setSalesOrderStatus(SalesOrderStatus.OPEN);
		salesOrder.setSalesOrderValue(50);
		salesOrder.setDiscountPercent(0);
		salesOrder.setDiscountValue(0);
		
		SalesOrderItem salesOrderItem = SalesOrderItemFake.toFake();
		salesOrderItem.setSalesOrder(salesOrder);
		
		salesOrder.setListOfSalesOrderItem(new ArrayList<>());
		salesOrder.getListOfSalesOrderItem().add(salesOrderItem);

		return salesOrder;
	}
	
	public static SalesOrderInputDTO toFakeInputDTO() {
		SalesOrderInputDTO salesOrder = new SalesOrderInputDTO();
		salesOrder.setId(1L);
		salesOrder.setClientId(1L);
		salesOrder.setClientName("Cliente teste");
		salesOrder.setQuantityTotal(10);
		salesOrder.setSalesOrderStatus(SalesOrderStatus.OPEN);
		salesOrder.setSalesOrderValue(50);
		salesOrder.setDiscountPercent(0);
		salesOrder.setDiscountValue(0);
		
		SalesOrderItemDTO salesOrderItem = SalesOrderItemFake.toFakeDTO();
		
		salesOrder.setListOfSalesOrderItem(new ArrayList<>());
		salesOrder.getListOfSalesOrderItem().add(salesOrderItem);

		return salesOrder;
	}
}
