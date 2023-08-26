package br.com.systec.sales.api.v1.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.systec.sales.api.v1.dto.SalesOrderItemDTO;
import br.com.systec.sales.fake.SalesOrderItemFake;
import br.com.systec.sales.model.SalesOrderItem;

public class SalesOrderItemConverterTest {
	
	
	@Test
	void converterSalesOrderItemToSalesOrderItemDTOTest() {
		SalesOrderItem salesOrderItem = SalesOrderItemFake.toFake();
		
		SalesOrderItemDTO salesOrderItemDTO = SalesOrderItemConverter.getInstance().toDTO(salesOrderItem);
		
        assertEquals(salesOrderItem.getId(), salesOrderItemDTO.getId());
        assertEquals(salesOrderItem.getProductId(), salesOrderItemDTO.getProductId());
        assertEquals(salesOrderItem.getProductDescription(), salesOrderItemDTO.getProductDescription());
        assertEquals(salesOrderItem.getDiscountPercent(), salesOrderItemDTO.getDiscountPercent());
        assertEquals(salesOrderItem.getDiscountValue(), salesOrderItemDTO.getDiscountValue());
        assertEquals(salesOrderItem.getQuantity(), salesOrderItemDTO.getQuantity());
        assertEquals(salesOrderItem.getSubTotal(), salesOrderItemDTO.getSubTotal());
        assertEquals(salesOrderItem.getUnitValue(), salesOrderItemDTO.getUnitValue());
        assertEquals(salesOrderItem.getAmount(), salesOrderItemDTO.getAmount());
	}
}
