package br.com.systec.erpfake.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.systec.erpfake.product.fallbacks.StockClientFallback;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@FeignClient(name = "stock", fallback = StockClientFallback.class)
public interface StockClient {

	@GetMapping("/api/v1/stocks/productQuantity/{productId}")
	Double getProductQuantity(@PathVariable(name = "productId") Long productId);
}
