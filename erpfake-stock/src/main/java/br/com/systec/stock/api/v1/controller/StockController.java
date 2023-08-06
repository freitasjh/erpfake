package br.com.systec.stock.api.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systec.stock.service.StockService;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@RestController
@RequestMapping("/api/v1/stocks")
public class StockController {
	
	@Autowired
	private StockService stockService;

	@GetMapping(value = "/productQuantity/{productId}")
	public ResponseEntity<Double> getQuantityProductStock(@PathVariable(name = "productId") Long productId) {
		Double productQuantityStock = stockService.getQuantityStockProduct(productId);
		
		return ResponseEntity.ok(productQuantityStock);
	}	
}
