package br.com.systec.stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Autowired
	private StockRepository repository;
	
	@Transactional
	public void save(Stock stock) {
		repository.save(stock);
	}
	
	public Double getQuantityStockProduct(Long productId) {
		Double stockQuantity = repository.stockQuantityProduct(productId);
		
		return stockQuantity;
	}
}
