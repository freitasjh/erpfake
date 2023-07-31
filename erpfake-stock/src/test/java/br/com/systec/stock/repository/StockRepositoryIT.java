package br.com.systec.stock.repository;

import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.systec.stock.AbstractIT;
import br.com.systec.stock.enums.TransactionType;
import br.com.systec.stock.model.Stock;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StockRepositoryIT extends AbstractIT{
	
	@Autowired
	private StockRepository repository;
	
	@Test
	@Order(1)
	void saveInputStockTest() {
		Stock stock = new Stock();
		stock.setProductId(1L);
		stock.setQuantity(20);
		stock.setDateTransaction(new Date());
		stock.setTransactionType(TransactionType.INPUT);
		
		Stock stockSave = repository.save(stock);
		
		Assertions.assertThat(stockSave.getId()).isNotNull();
	}
	
	@Test
	@Order(2)
	void saveOutputtockTest() {
		Stock stock = new Stock();
		stock.setProductId(1L);
		stock.setDateTransaction(new Date());
		stock.setQuantity(15);
		stock.setTransactionType(TransactionType.OUTPUT);
		
		Stock stockSave = repository.save(stock);
		
		Assertions.assertThat(stockSave.getId()).isNotNull();
	}
	
	@Test
	@Order(3)
	void getStockQuantityProductId() {
		Double quantity = repository.stockQuantityProduct(1L);
		
		System.out.println(quantity);
		
		Assertions.assertThat(quantity).isEqualTo(5.0);
	}
}
