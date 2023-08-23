package br.com.systec.purchase.service;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.systec.purchase.fake.PurchaseOrderFake;
import br.com.systec.purchase.model.PurchaseOrder;
import br.com.systec.purchase.repository.PurchaseOrderRepository;

@ExtendWith(MockitoExtension.class)
public class PurchaseOrderServiceTest {

	@Mock
	private PurchaseOrderRepository repository;
	
	@InjectMocks
	private PurchaseOrderService service;
	
	
	@Test
	void savePurchaseOrderTest() {
		PurchaseOrder purchaseOrderSave = PurchaseOrderFake.toFake();
		
		PurchaseOrder purchaseOrder = PurchaseOrderFake.toFake();
		purchaseOrder.setId(null);
		
		doReturn(purchaseOrderSave).when(repository).save(purchaseOrder);
		
		PurchaseOrder purchaseOrderReturn = service.save(purchaseOrder);
		
		Assertions.assertThat(purchaseOrderReturn.getId()).isNotNull();
		Assertions.assertThat(purchaseOrderReturn.getId()).isEqualTo(purchaseOrderSave.getId());
		
		
		verify(repository).save(purchaseOrder);
	}
}
