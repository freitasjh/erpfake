package br.com.systec.purchase.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.systec.purchase.AbstractIT;
import br.com.systec.purchase.fake.PurchaseOrderFake;
import br.com.systec.purchase.model.PurchaseItem;
import br.com.systec.purchase.model.PurchaseOrder;

@SpringBootTest
public class PurchaseOrderRepositoryTest extends AbstractIT{
	private static final Logger log = LoggerFactory.getLogger(PurchaseOrderRepositoryTest.class);
	
	@Autowired
	private PurchaseOrderRepository repository;
	
	@Test
	void savePurchaseOrderTest() {
		log.warn("==============================================");
		log.warn("=========== Salvando purchase Order ==========");
		log.warn("==============================================");
		PurchaseOrder purchaseOrder = PurchaseOrderFake.toFake();
		purchaseOrder.setId(null);
		
		for(PurchaseItem item : purchaseOrder.getListOfPurchaseItem()) {
			item.setId(null);
			item.setPurchaseOrder(purchaseOrder);
		}
		
		PurchaseOrder purchaseOrderSave = repository.save(purchaseOrder);
		
		Assertions.assertThat(purchaseOrderSave.getId()).isNotNull();
	}
}
