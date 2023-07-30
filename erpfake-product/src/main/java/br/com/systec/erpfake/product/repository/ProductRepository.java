package br.com.systec.erpfake.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systec.erpfake.product.model.Product;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
