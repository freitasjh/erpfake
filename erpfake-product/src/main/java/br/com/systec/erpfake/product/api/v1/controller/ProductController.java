package br.com.systec.erpfake.product.api.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.systec.erpfake.product.api.v1.converter.ProductConverter;
import br.com.systec.erpfake.product.api.v1.dto.ProductDTO;
import br.com.systec.erpfake.product.api.v1.dto.ProductInputDTO;
import br.com.systec.erpfake.product.model.Product;
import br.com.systec.erpfake.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "/products")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping
	@Operation(description = "Retorna todos os produtos cadastrado")
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<Product> listOfProduct = service.findAll();

		List<ProductDTO> listOfProductDTO = ProductConverter.getInstance().toListDTO(listOfProduct);

		return ResponseEntity.ok(listOfProductDTO);
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(description = "Save informações do produto")
	public ResponseEntity<ProductInputDTO> save(@RequestBody ProductInputDTO productInput) {
		Product product = ProductConverter.getInstance().toEntity(productInput);

		Product productSave = service.save(product);

		return ResponseEntity.ok(ProductConverter.getInstance().toInputDTO(productSave));
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(description = "Atualiza informações do produto")
	public ResponseEntity<ProductInputDTO> update(@RequestBody ProductInputDTO productInput) {
		Product product = ProductConverter.getInstance().toEntity(productInput);

		Product productSave = service.update(product);

		return ResponseEntity.ok(ProductConverter.getInstance().toInputDTO(productSave));
	}
}
