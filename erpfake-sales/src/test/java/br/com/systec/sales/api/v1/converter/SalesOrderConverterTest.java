package br.com.systec.sales.api.v1.converter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import br.com.systec.sales.api.v1.dto.SalesOrderDTO;
import br.com.systec.sales.api.v1.dto.SalesOrderInputDTO;
import br.com.systec.sales.fake.SalesOrderFake;
import br.com.systec.sales.model.SalesOrder;

public class SalesOrderConverterTest {
	
	@Test
	void converterSaleOrderToSalesOrderDTOTest() {
		SalesOrder salesOrder = SalesOrderFake.toFake();
		
		SalesOrderDTO salesOrderDTO = SalesOrderConverter.getInstance().toDTO(salesOrder);
		
		assertThat(salesOrder.getId()).isEqualTo(salesOrderDTO.getId());
		assertThat(salesOrder.getClientId()).isEqualTo(salesOrderDTO.getClientId());
		assertThat(salesOrder.getClientName()).isEqualTo(salesOrderDTO.getClientName());
		assertThat(salesOrder.getQuantityTotal()).isEqualTo(salesOrderDTO.getQuantity());
		assertThat(salesOrder.getSalesOrderValue()).isEqualTo(salesOrderDTO.getSalesOrderValue());
		assertThat(salesOrder.getSalesOrderStatus()).isEqualTo(salesOrderDTO.getSalesOrderStatus());
	}
	
	@Test
	void converterSalesOrderToSalesOrderInputDTOTest() {
		SalesOrder salesOrder = SalesOrderFake.toFake();
		
		SalesOrderInputDTO inputDTO = SalesOrderConverter.getInstance().toInputDTO(salesOrder);
		
		assertThat(salesOrder.getId()).isEqualTo(inputDTO.getId());
		assertThat(salesOrder.getClientId()).isEqualTo(inputDTO.getClientId());
		assertThat(salesOrder.getClientName()).isEqualTo(inputDTO.getClientName());
		assertThat(salesOrder.getDiscountPercent()).isEqualTo(inputDTO.getDiscountPercent());
		assertThat(salesOrder.getDiscountValue()).isEqualTo(inputDTO.getDiscountValue());
		assertThat(salesOrder.getQuantityTotal()).isEqualTo(inputDTO.getQuantityTotal());
		assertThat(salesOrder.getSalesOrderStatus()).isEqualTo(inputDTO.getSalesOrderStatus());
		assertThat(salesOrder.getSalesOrderValue()).isEqualTo(inputDTO.getSalesOrderValue());
		
		assertThat(inputDTO.getListOfSalesOrderItem()).isNotEmpty();
		assertThat(inputDTO.getListOfSalesOrderItem().get(0).getId()).isEqualTo(salesOrder.getListOfSalesOrderItem().get(0).getId());
	}
	
	@Test
	void converterSalesOrderInputDTOToSalesOrderTest() {
		SalesOrderInputDTO inputDTO = SalesOrderFake.toFakeInputDTO();
		
		SalesOrder salesOrder = SalesOrderConverter.getInstance().toEntity(inputDTO);
		
		assertThat(salesOrder.getId()).isEqualTo(inputDTO.getId());
		assertThat(salesOrder.getClientId()).isEqualTo(inputDTO.getClientId());
		assertThat(salesOrder.getClientName()).isEqualTo(inputDTO.getClientName());
		assertThat(salesOrder.getDiscountPercent()).isEqualTo(inputDTO.getDiscountPercent());
		assertThat(salesOrder.getDiscountValue()).isEqualTo(inputDTO.getDiscountValue());
		assertThat(salesOrder.getQuantityTotal()).isEqualTo(inputDTO.getQuantityTotal());
		assertThat(salesOrder.getSalesOrderStatus()).isEqualTo(inputDTO.getSalesOrderStatus());
		assertThat(salesOrder.getSalesOrderValue()).isEqualTo(inputDTO.getSalesOrderValue());
		
		assertThat(salesOrder.getListOfSalesOrderItem()).isNotEmpty();
		assertThat(salesOrder.getListOfSalesOrderItem().get(0).getId()).isEqualTo(inputDTO.getListOfSalesOrderItem().get(0).getId());
		assertThat(salesOrder.getListOfSalesOrderItem().get(0).getSalesOrder()).isNotNull();
	}
	
	
}
