package br.com.systec.purchase.api.v1.converter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.systec.purchase.api.v1.dto.PurchaseItemDTO;
import br.com.systec.purchase.fake.PurchaseItemFake;
import br.com.systec.purchase.model.PurchaseItem;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
public class PurchaseItemConverterTest {
	
	@Test
	void converterPurchaseItemOrderToPurchaseItemOrderDTOTest() {
		PurchaseItemDTO itemDTO = PurchaseItemFake.toFakeItemDTO();
		
		PurchaseItem purchaseItem = PurchaseItemConverter.getInstance().toEntity(itemDTO);
		
		Assertions.assertThat(itemDTO.getId()).isEqualTo(purchaseItem.getId());
		Assertions.assertThat(itemDTO.getProductId()).isEqualTo(purchaseItem.getProductId());
		Assertions.assertThat(itemDTO.getProductDescription()).isEqualTo(purchaseItem.getProductDescription());
		Assertions.assertThat(itemDTO.getAmount()).isEqualTo(purchaseItem.getAmount());
		Assertions.assertThat(itemDTO.getQuantity()).isEqualTo(purchaseItem.getQuantity());
		Assertions.assertThat(itemDTO.getUnitaryValue()).isEqualTo(purchaseItem.getUnitaryValue());		
	}
	
	@Test
	void convertPurchaseItemToPurchaseItemDTO() {
		PurchaseItem purchaseItem = PurchaseItemFake.toFakeItem();
		
		PurchaseItemDTO itemDTO = PurchaseItemConverter.getInstance().toDTO(purchaseItem);
		
		Assertions.assertThat(itemDTO.getId()).isEqualTo(purchaseItem.getId());
		Assertions.assertThat(itemDTO.getProductId()).isEqualTo(purchaseItem.getProductId());
		Assertions.assertThat(itemDTO.getProductDescription()).isEqualTo(purchaseItem.getProductDescription());
		Assertions.assertThat(itemDTO.getAmount()).isEqualTo(purchaseItem.getAmount());
		Assertions.assertThat(itemDTO.getQuantity()).isEqualTo(purchaseItem.getQuantity());
		Assertions.assertThat(itemDTO.getUnitaryValue()).isEqualTo(purchaseItem.getUnitaryValue());		
	}
}
