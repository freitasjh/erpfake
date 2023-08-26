package br.com.systec.sales.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sales_order_item")
public class SalesOrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "product_id")
	private Long productId;
	@Column(name = "product_description")
	private String productDescription;
	@Column(name = "unit_value")
	private double unitValue;
	@Column(name = "amount")
	private double amount;
	@Column(name = "quantity")
	private double quantity;
	@Column(name = "sub_total")
	private double subTotal;
	@Column(name = "discount_value")
	private double discountValue;
	@Column(name = "discount_percent")
	private double discountPercent;
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "sales_order_id")
	private SalesOrder salesOrder;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public double getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(double unitValue) {
		this.unitValue = unitValue;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double descountValue) {
		this.discountValue = descountValue;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double descountPercent) {
		this.discountPercent = descountPercent;
	}

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

}
