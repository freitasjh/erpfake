package br.com.systec.sales.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.systec.sales.enums.SalesOrderStatus;
import br.com.systec.sales.fake.SalesOrderFake;
import br.com.systec.sales.model.SalesOrder;
import br.com.systec.sales.repository.SalesOrderRepository;

@ExtendWith(MockitoExtension.class)
public class SalesOrderServiceTest {

	@Mock
	private SalesOrderRepository repository;
	
	@Mock
	private SalesStockService salesStockService;
	
	@InjectMocks
	private SalesOrderService service;
	
	
	@Test
	void saveSalesOrderTest() {
		SalesOrder salesOrder = SalesOrderFake.toFake();
		salesOrder.setId(null);
		salesOrder.getListOfSalesOrderItem().stream().forEach(item -> item.setId(null));
		
		SalesOrder salesOrderReturn = SalesOrderFake.toFake();
		
		doReturn(salesOrderReturn).when(repository).save(salesOrder);
		doNothing().when(salesStockService).sendSalesStock(salesOrder);
		
		SalesOrder salesOrderSaved = service.save(salesOrder);
		
		Assertions.assertThat(salesOrderSaved.getId()).isEqualTo(salesOrderReturn.getId());
		Assertions.assertThat(salesOrderSaved.getSalesOrderStatus()).isEqualTo(salesOrderReturn.getSalesOrderStatus());
		
		verify(repository).save(salesOrder);
		verify(salesStockService).sendSalesStock(salesOrderSaved);
	}
	
	@Test
	void updateSaleOrderTest() {
		SalesOrder salesOrder = SalesOrderFake.toFake();
		
		SalesOrder salesOrderReturn = SalesOrderFake.toFake();
		
		doReturn(salesOrderReturn).when(repository).save(salesOrder);
		
		SalesOrder salesOrderSaved = service.update(salesOrder);
		
		Assertions.assertThat(salesOrderSaved.getId()).isEqualTo(salesOrderReturn.getId());
		Assertions.assertThat(salesOrderSaved.getSalesOrderStatus()).isEqualTo(salesOrderReturn.getSalesOrderStatus());
		
		verify(repository).save(salesOrder);
	}
	
	@Test
	void findAllSalesOrderTest() {
		List<SalesOrder> listSalesOrders = new ArrayList<>();
		listSalesOrders.add(SalesOrderFake.toFake());
		
		doReturn(listSalesOrders).when(repository).findAll();
		
		List<SalesOrder> listSalesOrderReturn = service.findAll();
		
		Assertions.assertThat(listSalesOrderReturn).isNotEmpty();
		
		verify(repository).findAll();
	}
	
	@Test
	void finalizeSalesOrderTest() {
		SalesOrder salesOrderReturn = SalesOrderFake.toFake();
		
		doReturn(Optional.of(salesOrderReturn)).when(repository).findById(1L);
		
		SalesOrder salesOrderReturnFinalize = SalesOrderFake.toFake();
		salesOrderReturnFinalize.setSalesOrderStatus(SalesOrderStatus.FINALIZE);
		
		doReturn(salesOrderReturnFinalize).when(repository).save(Mockito.any());
		
		SalesOrder salesOrderFinalize = service.finalize(1L);
		
		Assertions.assertThat(salesOrderFinalize.getSalesOrderStatus()).isEqualTo(SalesOrderStatus.FINALIZE);
	
		verify(repository).findById(1L);
		verify(repository).save(Mockito.any());
	}
	
	@Test
	void finalizeSalesOrderNotFoundExceptionTest() {
		when(repository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
		
		Assertions.assertThatThrownBy(() -> service.findById(Mockito.anyLong())).isExactlyInstanceOf(RuntimeException.class);
		verify(repository).findById(Mockito.anyLong());		
	}
	
}
