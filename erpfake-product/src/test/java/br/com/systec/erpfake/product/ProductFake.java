package br.com.systec.erpfake.product;

import br.com.systec.erpfake.product.model.Product;

public class ProductFake {
	
	public static Product fakeEntity() {
		Product product = new Product();
		product.setId(1L);
		product.setCode("1");
		product.setDescription("Produto teste");
		product.setPrice(10.00);
		
		return product;		
	}
}
