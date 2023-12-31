package br.com.systec.stock.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.systec.stock.amqp.dto.StockOrderDTO;
import br.com.systec.stock.amqp.dto.StockOrderItemDTO;
import br.com.systec.stock.enums.TransactionType;
import br.com.systec.stock.model.Stock;
import br.com.systec.stock.repository.StockRepository;
import jakarta.transaction.Transactional;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@Service
public class StockService {
	private static final Logger LOG = LoggerFactory.getLogger(StockService.class);
	
	@Autowired
	private StockRepository repository;
	
	@Transactional
	public void save(Stock stock) {
		repository.save(stock);
	}
	
	@Transactional
	public void stockSave(StockOrderDTO stockOrderDTO) {
		LOG.info("Salvando as quantidades dos produtos no stock");
		for(StockOrderItemDTO item : stockOrderDTO.getListOfSalesOrderItem()) {
			Stock stock = new Stock();
			stock.setProductId(item.getProductId());
			stock.setQuantity(item.getQuantity());
			stock.setTransactionType(TransactionType.valueOf(stockOrderDTO.getTransactionType()));
			stock.setDateTransaction(stockOrderDTO.getDateOrderFinalize());
			
			save(stock);
		}
		
		LOG.info("Quantidade no stock foram salvos com sucesso");
	}
	
	public Double getQuantityStockProduct(Long productId) {
		Double stockQuantity = repository.stockQuantityProduct(productId);
		
		if(stockQuantity == null) {
			stockQuantity = 0.0;
		}
		
		return stockQuantity;
	}
}
