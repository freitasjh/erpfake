package br.com.systec.erpfake.product;

import br.com.systec.erpfake.product.api.v1.dto.ProductInputDTO;
import br.com.systec.erpfake.product.model.Product;

public class ProductFake {
	
	public static Product fakeEntity() {
		Product product = new Product();
		product.setId(1L);
		product.setCode("1");
		product.setDescription("Produto teste");
		product.setPrice(10.00);
		product.setQuantity(50);
		
		return product;		
	}
	
	public static ProductInputDTO fakeInputDTO() {
		ProductInputDTO product = new ProductInputDTO();
		product.setId(1L);
		product.setCode("1");
		product.setDescription("Produto teste");
		product.setPrice(10.00);
		
		return product;		
	}
}
