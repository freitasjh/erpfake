package br.com.systec.erpfake.product.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.systec.erpfake.product.ProductFake;
import br.com.systec.erpfake.product.client.StockClient;
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
	
	@Mock
	private StockClient stocClient;
	
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
	
	@Test
	void findProductById() {
		Double productQuantity = 10.0;
		Optional<Product> product = Optional.of(ProductFake.fakeEntity());
		
		doReturn(productQuantity).when(stocClient).getProductQuantity(Mockito.anyLong());
		when(repository.findById(Mockito.anyLong())).thenReturn(product);
	
		Product productReturn = service.findById(Mockito.anyLong());
		
		Assertions.assertThat(productReturn.getQuantity()).isEqualTo(productQuantity);
		Assertions.assertThat(productReturn.getId()).isEqualTo(product.get().getId());
		
		Mockito.verify(repository).findById(Mockito.anyLong());
		Mockito.verify(stocClient).getProductQuantity(Mockito.anyLong());
	}	
}
