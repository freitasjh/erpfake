package br.com.systec.purchase.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.systec.purchase.enums.OrderStatus;
import br.com.systec.purchase.model.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

	List<PurchaseOrder> findByOrderStatus(OrderStatus orderStatus);
}
