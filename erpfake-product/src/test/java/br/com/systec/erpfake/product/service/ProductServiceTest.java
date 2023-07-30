package br.com.systec.erpfake.product.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.systec.erpfake.product.ProductFake;
import br.com.systec.erpfake.product.model.Product;
import br.com.systec.erpfake.product.repository.ProductRepository;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	
	@Mock
	private ProductRepository repository;
	
	@InjectMocks
	private ProductService service;
	
	@Test
	void saveProductTest() {
		Product product = ProductFake.fakeEntity();
		product.setId(null);
		
		Mockito.doReturn(product).when(repository).save(Mockito.any());
		
		Product productSave = service.save(product);
		
		Assertions.assertThat(product.getId()).isEqualTo(productSave.getId());
		Assertions.assertThat(product.getDescription()).isEqualTo(productSave.getDescription());
		
		Mockito.verify(repository).save(Mockito.any());
	}
	
	@Test
	void updateProductTest() {
		Product product = ProductFake.fakeEntity();
		product.setId(1L);
		
		Mockito.doReturn(product).when(repository).save(Mockito.any());
		
		Product productSave = service.update(product);
		
		Assertions.assertThat(product.getId()).isEqualTo(productSave.getId());
		Assertions.assertThat(product.getDescription()).isEqualTo(productSave.getDescription());
		
		Mockito.verify(repository).save(Mockito.any());
	}
	
	@Test
	void updateProductRuntimeExceptionIfNotIdTest() {
		Product product = ProductFake.fakeEntity();
		product.setId(null);
		
		assertThrows(RuntimeException.class, () -> {
			service.update(product);
		});
	}
	
	@Test
	void findAllProductTest() {
		List<Product> listOfProduct = new ArrayList<>();
		listOfProduct.add(ProductFake.fakeEntity());
		
		Mockito.doReturn(listOfProduct).when(repository).findAll();
		
		List<Product> listOfProductReturn = service.findAll();
		
		Assertions.assertThat(listOfProductReturn).isNotEmpty();
		Assertions.assertThat(listOfProductReturn.size()).isEqualTo(1);
		
		Mockito.verify(repository).findAll();		
	}
}
