package br.com.systec.erpfake.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.systec.erpfake.product.model.Product;
import br.com.systec.erpfake.product.repository.ProductRepository;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional
	public Product save(Product product) {
		Product productSave = repository.save(product);
		
		return productSave;
	}
	
	@Transactional
	public Product update(Product product) {
		if(product.getId() == null) {
			throw new RuntimeException("Produto sem o id,favor informe o id para conseguir atualizar o produto");
		}
		
		Product productSave = repository.save(product);
		
		return productSave;
	}
	
	public List<Product> findAll() {
		List<Product> listOfProduct = repository.findAll();
		
		return listOfProduct;
	}
}
