package br.com.systec.purchase.model;

import java.util.List;

import br.com.systec.purchase.enums.OrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
@Entity
@Table(name = "purchase_order")
public class PurchaseOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "code")
	private String code;
	@Column(name = "quantity")
	private double quantity;
	@Column(name = "amount")
	private double amount;
	@Column(name = "sub_total")
	private double subTotal;
	@OneToMany(fetch = FetchType.EAGER, targetEntity = PurchaseItem.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "purchase_order_id")
	private List<PurchaseItem> listOfPurchaseItem;
	@Column(name = "order_status")
	@Enumerated(EnumType.ORDINAL)
	private OrderStatus orderStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	public List<PurchaseItem> getListOfPurchaseItem() {
		return listOfPurchaseItem;
	}
	
	public void setListOfPurchaseItem(List<PurchaseItem> listOfPurchaseItem) {
		this.listOfPurchaseItem = listOfPurchaseItem;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
