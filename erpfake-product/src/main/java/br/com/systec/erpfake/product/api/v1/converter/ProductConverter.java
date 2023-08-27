package br.com.systec.erpfake.product.api.v1.converter;

import java.util.List;

import br.com.systec.erpfake.product.api.v1.dto.ProductDTO;
import br.com.systec.erpfake.product.api.v1.dto.ProductInputDTO;
import br.com.systec.erpfake.product.model.Product;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
public class ProductConverter {
	
	private static ProductConverter instance;
	
	public static ProductConverter getInstance() {
		if(instance == null) {
			instance = new ProductConverter();
		}
		
		return instance;
	}
	
	private ProductConverter() {
		
	}
	
	public Product toEntity(ProductInputDTO productInput) {
		Product product = new Product();
		product.setId(productInput.getId());
		product.setCode(productInput.getCode());
		product.setCodeEan(productInput.getCodEan());
		product .setDescription(productInput.getDescription());
		product.setPrice(productInput.getPrice());
		
		return product;
	}
	
	public ProductInputDTO toInputDTO(Product product) {
		ProductInputDTO productInput = new ProductInputDTO();
		productInput.setId(product.getId());
		productInput.setCode(product.getCode());
		productInput.setCodEan(product.getCodeEan());
		productInput.setDescription(product.getDescription());
		productInput.setPrice(product.getPrice());
		productInput.setQuantity(product.getQuantity());
		
		return productInput;
	}
	
	public ProductDTO toDTO(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setDescription(product.getDescription());
		productDTO.setPrice(product.getPrice());
		productDTO.setQuantity(product.getQuantity());
		
		return productDTO;
	}
	
	public List<ProductDTO> toListDTO(List<Product> listOfProduct){
		return listOfProduct.stream().map(this::toDTO).toList();
	}
}
