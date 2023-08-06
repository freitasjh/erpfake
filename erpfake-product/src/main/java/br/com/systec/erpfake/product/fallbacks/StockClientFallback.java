package br.com.systec.erpfake.product.fallbacks;

import org.springframework.stereotype.Component;

import br.com.systec.erpfake.product.client.StockClient;

@Component
public class StockClientFallback implements StockClient{

	@Override
	public Double getProductQuantity(Long productId) {
		System.err.println("Erro ao tentar pegar a quantidade do produto, retornando o valor original");
		return -1.00;
	}

}
