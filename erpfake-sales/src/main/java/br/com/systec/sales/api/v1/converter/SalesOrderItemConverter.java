package br.com.systec.sales.api.v1.converter;

import br.com.systec.sales.api.v1.dto.SalesOrderItemDTO;
import br.com.systec.sales.model.SalesOrderItem;

public class SalesOrderItemConverter {
	private static SalesOrderItemConverter instance;
	
	public static SalesOrderItemConverter getInstance() {
		if(instance == null) {
			instance = new SalesOrderItemConverter();
		}
		
		return instance;
	}
	
	
	private SalesOrderItemConverter() {}
	
	
	public SalesOrderItemDTO toDTO(SalesOrderItem salesOrderItem) {
		SalesOrderItemDTO salesOrderItemDTO = new SalesOrderItemDTO();
		
		salesOrderItemDTO.setId(salesOrderItem.getId());
		salesOrderItemDTO.setProductId(salesOrderItem.getProductId());
		salesOrderItemDTO.setProductDescription(salesOrderItem.getProductDescription());
		salesOrderItemDTO.setDiscountPercent(salesOrderItem.getDiscountPercent());
		salesOrderItemDTO.setDiscountValue(salesOrderItem.getDiscountValue());
		salesOrderItemDTO.setQuantity(salesOrderItem.getQuantity());
		salesOrderItemDTO.setSubTotal(salesOrderItem.getSubTotal());
		salesOrderItemDTO.setUnitValue(salesOrderItem.getUnitValue());
		salesOrderItemDTO.setAmount(salesOrderItem.getAmount());
		
		return salesOrderItemDTO;
	}
	
	public SalesOrderItem toEntity(SalesOrderItemDTO salesOrderItemDTO) {
		SalesOrderItem salesOrderItem = new SalesOrderItem();
		
		salesOrderItem.setId(salesOrderItemDTO.getId());
		salesOrderItem.setProductId(salesOrderItemDTO.getProductId());
		salesOrderItem.setProductDescription(salesOrderItemDTO.getProductDescription());
		salesOrderItem.setDiscountPercent(salesOrderItemDTO.getDiscountPercent());
		salesOrderItem.setDiscountValue(salesOrderItemDTO.getDiscountValue());
		salesOrderItem.setQuantity(salesOrderItemDTO.getQuantity());
		salesOrderItem.setSubTotal(salesOrderItemDTO.getSubTotal());
		salesOrderItem.setUnitValue(salesOrderItemDTO.getUnitValue());
		salesOrderItem.setAmount(salesOrderItemDTO.getAmount());
		
		return salesOrderItem;
	}
	
}
