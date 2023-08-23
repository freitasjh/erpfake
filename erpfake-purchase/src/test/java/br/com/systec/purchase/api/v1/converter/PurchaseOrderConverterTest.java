package br.com.systec.purchase.api.v1.converter;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.systec.purchase.api.v1.dto.PurchaseOrderDTO;
import br.com.systec.purchase.api.v1.dto.PurchaseOrderInputDTO;
import br.com.systec.purchase.fake.PurchaseOrderFake;
import br.com.systec.purchase.model.PurchaseOrder;

public class PurchaseOrderConverterTest {
	
	@Test
	void converterPurchaseOrderInputDTOToPurchaseOrderTest() {
		PurchaseOrderInputDTO inputDTO = PurchaseOrderFake.toFakeInputDTO();
		
		PurchaseOrder purchaseOrder = PurchaseOrderConverter.getInstance().toEntity(inputDTO);
		
		Assertions.assertThat(purchaseOrder.getId()).isEqualTo(inputDTO.getId());
		Assertions.assertThat(purchaseOrder.getQuantity()).isEqualTo(inputDTO.getQuantity());
		Assertions.assertThat(purchaseOrder.getListOfPurchaseItem()).isNotEmpty();		
		Assertions.assertThat(purchaseOrder.getOrderStatus()).isEqualTo(inputDTO.getOrderStatus());
	}
	
	@Test
	void converterPurchaseOrderToPurchaseOrderInputDTOTest() {
		PurchaseOrder purchaseOrder = PurchaseOrderFake.toFake();
		
		PurchaseOrderInputDTO inputDTO = PurchaseOrderConverter.getInstance().toInputDTO(purchaseOrder);
		
		Assertions.assertThat(inputDTO.getId()).isEqualTo(purchaseOrder.getId());
		Assertions.assertThat(inputDTO.getCode()).isEqualTo(purchaseOrder.getCode());
		Assertions.assertThat(inputDTO.getQuantity()).isEqualTo(purchaseOrder.getQuantity());
		Assertions.assertThat(inputDTO.getAmount()).isEqualTo(purchaseOrder.getAmount());
		Assertions.assertThat(inputDTO.getOrderStatus()).isEqualTo(purchaseOrder.getOrderStatus());
		Assertions.assertThat(inputDTO.getSubtotal()).isEqualTo(purchaseOrder.getSubTotal());
		Assertions.assertThat(inputDTO.getListOfPurchaseItem()).isNotEmpty();
	}
	
	@Test
	void converterPurchaseOrderToPurchaseOrderDTO() {
		PurchaseOrder purchaseOrder = PurchaseOrderFake.toFake();
		
		PurchaseOrderDTO purchaseOrderDTO = PurchaseOrderConverter.getInstance().toDTO(purchaseOrder);
		
		Assertions.assertThat(purchaseOrderDTO.getId()).isEqualTo(purchaseOrder.getId());
		Assertions.assertThat(purchaseOrderDTO.getAmmount()).isEqualTo(purchaseOrder.getAmount());
		Assertions.assertThat(purchaseOrderDTO.getQuantity()).isEqualTo(purchaseOrder.getQuantity());
		Assertions.assertThat(purchaseOrderDTO.getCode()).isEqualTo(purchaseOrder.getCode());
	}
	
	@Test
	void converterListPurchaseOrderToListPurchaseOrderDTOTest() {
		List<PurchaseOrder> listOfPurchaseOrder = new ArrayList<>();
		listOfPurchaseOrder.add(PurchaseOrderFake.toFake());
		
		List<PurchaseOrderDTO> listOfPurchaseOrderDTO = PurchaseOrderConverter.getInstance().toListDTO(listOfPurchaseOrder);
		
		Assertions.assertThat(listOfPurchaseOrderDTO).isNotEmpty();
		Assertions.assertThat(listOfPurchaseOrderDTO.get(0).getId()).isEqualTo(listOfPurchaseOrder.get(0).getId());
	}
}
