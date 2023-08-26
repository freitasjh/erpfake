package br.com.systec.sales.api.v1.converter;

import java.util.ArrayList;
import java.util.List;

import br.com.systec.sales.api.v1.dto.SalesOrderDTO;
import br.com.systec.sales.api.v1.dto.SalesOrderInputDTO;
import br.com.systec.sales.api.v1.dto.SalesOrderItemDTO;
import br.com.systec.sales.model.SalesOrder;
import br.com.systec.sales.model.SalesOrderItem;

public class SalesOrderConverter {
	private static SalesOrderConverter instance;

	public static SalesOrderConverter getInstance() {
		if (instance == null) {
			instance = new SalesOrderConverter();
		}

		return instance;
	}

	private SalesOrderConverter() {
	}

	public SalesOrderDTO toDTO(SalesOrder salesOrder) {
		SalesOrderDTO salesOrderDTO = new SalesOrderDTO();
		salesOrderDTO.setId(salesOrder.getId());
		salesOrderDTO.setClientId(salesOrder.getClientId());
		salesOrderDTO.setClientName(salesOrder.getClientName());
		salesOrderDTO.setQuantity(salesOrder.getQuantityTotal());
		salesOrderDTO.setSalesOrderStatus(salesOrder.getSalesOrderStatus());
		salesOrderDTO.setSalesOrderValue(salesOrder.getSalesOrderValue());

		return salesOrderDTO;
	}

	public SalesOrderInputDTO toInputDTO(SalesOrder salesOrder) {
		SalesOrderInputDTO inputDTO = new SalesOrderInputDTO();

		inputDTO.setId(salesOrder.getId());
		inputDTO.setClientId(salesOrder.getClientId());
		inputDTO.setClientName(salesOrder.getClientName());
		inputDTO.setDiscountPercent(salesOrder.getDiscountPercent());
		inputDTO.setDiscountValue(salesOrder.getDiscountValue());
		inputDTO.setQuantityTotal(salesOrder.getQuantityTotal());
		inputDTO.setSalesOrderStatus(salesOrder.getSalesOrderStatus());
		inputDTO.setSalesOrderValue(salesOrder.getSalesOrderValue());

		if (salesOrder.getListOfSalesOrderItem() != null && !salesOrder.getListOfSalesOrderItem().isEmpty()) {
			List<SalesOrderItemDTO> listOfSalesOrderItemDTO = new ArrayList<>();
			for (SalesOrderItem item : salesOrder.getListOfSalesOrderItem()) {
				listOfSalesOrderItemDTO.add(SalesOrderItemConverter.getInstance().toDTO(item));
			}

			inputDTO.setListOfSalesOrderItem(listOfSalesOrderItemDTO);
		}

		return inputDTO;
	}

	public SalesOrder toEntity(SalesOrderInputDTO inputDTO) {
		SalesOrder salesOrder = new SalesOrder();

		salesOrder.setId(inputDTO.getId());
		salesOrder.setClientId(inputDTO.getClientId());
		salesOrder.setClientName(inputDTO.getClientName());
		salesOrder.setDiscountPercent(inputDTO.getDiscountPercent());
		salesOrder.setDiscountValue(inputDTO.getDiscountValue());
		salesOrder.setQuantityTotal(inputDTO.getQuantityTotal());
		salesOrder.setSalesOrderStatus(inputDTO.getSalesOrderStatus());
		salesOrder.setSalesOrderValue(inputDTO.getSalesOrderValue());

		if (inputDTO.getListOfSalesOrderItem() != null && !inputDTO.getListOfSalesOrderItem().isEmpty()) {
			List<SalesOrderItem> listOfSalesOrderItem = new ArrayList<>();

			for (SalesOrderItemDTO item : inputDTO.getListOfSalesOrderItem()) {
				SalesOrderItem salesOrderItem = SalesOrderItemConverter.getInstance().toEntity(item);
				salesOrderItem.setSalesOrder(salesOrder);
				
				listOfSalesOrderItem.add(salesOrderItem);
			}
			
			salesOrder.setListOfSalesOrderItem(listOfSalesOrderItem);
		}
		
		return salesOrder;
	}
	
	public List<SalesOrderDTO> toListDTO(List<SalesOrder> listOfSalesOrder) {
		return listOfSalesOrder.stream().map(this::toDTO).toList();
	}

}
