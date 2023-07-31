package br.com.systec.erpfake.product.api.v1.converter;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import br.com.systec.erpfake.product.ProductFake;
import br.com.systec.erpfake.product.api.v1.dto.ProductDTO;
import br.com.systec.erpfake.product.api.v1.dto.ProductInputDTO;
import br.com.systec.erpfake.product.model.Product;

public class ProductConverterTest {

	@Test
	void converterProductToProductDTO() {
		Product product = ProductFake.fakeEntity();
		
		ProductDTO productDTO = ProductConverter.getInstance().toDTO(product);
		
		Assertions.assertThat(product.getId()).isEqualTo(productDTO.getId());
		Assertions.assertThat(product.getDescription()).isEqualTo(productDTO.getDescription());
		Assertions.assertThat(product.getPrice()).isEqualTo(productDTO.getPrice());
	}
	
	@Test
	void converterListProductTOListProductDTO() {
		List<Product> listOfProduct = Arrays.asList(ProductFake.fakeEntity());
		
		List<ProductDTO> listOfProductDTO = ProductConverter.getInstance().toListDTO(listOfProduct);
		
		Assertions.assertThat(listOfProductDTO).isNotEmpty();
		Assertions.assertThat(listOfProductDTO).hasSize(1);
	}
	
	@Test
	void converterProductToProductInputDTO() {
		Product product = ProductFake.fakeEntity();
		
		ProductInputDTO productInput = ProductConverter.getInstance().toInputDTO(product);
		
		Assertions.assertThat(productInput.getId()).isEqualTo(product.getId());
		Assertions.assertThat(productInput.getCode()).isEqualTo(product.getCode());
		Assertions.assertThat(productInput.getCodEan()).isEqualTo(product.getCodeEan());
		Assertions.assertThat(productInput.getDescription()).isEqualTo(product.getDescription());
		Assertions.assertThat(productInput.getPrice()).isEqualTo(product.getPrice());				
	}
	
	@Test
	void converterProductInputDTOToProduct() {
		ProductInputDTO productInput = ProductFake.fakeInputDTO();
		
		Product product = ProductConverter.getInstance().toEntity(productInput);
		
		Assertions.assertThat(productInput.getId()).isEqualTo(product.getId());
		Assertions.assertThat(productInput.getCode()).isEqualTo(product.getCode());
		Assertions.assertThat(productInput.getCodEan()).isEqualTo(product.getCodeEan());
		Assertions.assertThat(productInput.getDescription()).isEqualTo(product.getDescription());
		Assertions.assertThat(productInput.getPrice()).isEqualTo(product.getPrice());				
	}
}
