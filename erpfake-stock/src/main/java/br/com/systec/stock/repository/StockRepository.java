package br.com.systec.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.systec.stock.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	@Query(value = "Select SUM(CASE WHEN obj.transaction_type = '0' THEN obj.quantity ELSE -obj.quantity END) as stockQuantity from stock obj "
			+ "where obj.product_id = :productId", nativeQuery = true)
	public Double stockQuantityProduct(@Param("productId") Long productId);
}
