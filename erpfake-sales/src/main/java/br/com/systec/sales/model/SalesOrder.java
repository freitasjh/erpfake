package br.com.systec.sales.model;

import java.util.List;

import br.com.systec.sales.enums.SalesOrderStatus;
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

@Entity
@Table(name = "sales_order")
public class SalesOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "client_id")
	private Long clientId;
	@Column(name = "client_name")
	private String clientName;
	@Column(name = "sales_order_value")
	private double salesOrderValue;
	@Column(name = "discount_value")
	private double discountValue;
	@Column(name = "discount_percent")
	private double discountPercent;
	@Column(name = "quantity_total")
	private double quantityTotal;
	@OneToMany(fetch = FetchType.EAGER, targetEntity = SalesOrderItem.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "sales_order_id")
	private List<SalesOrderItem> listOfSalesOrderItem;
	@Column(name = "sales_order_status")
	@Enumerated(EnumType.ORDINAL)
	private SalesOrderStatus salesOrderStatus;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public double getSalesOrderValue() {
		return salesOrderValue;
	}

	public void setSalesOrderValue(double salesOrderValue) {
		this.salesOrderValue = salesOrderValue;
	}

	public double getQuantityTotal() {
		return quantityTotal;
	}

	public void setQuantityTotal(double quantityTotal) {
		this.quantityTotal = quantityTotal;
	}

	public List<SalesOrderItem> getListOfSalesOrderItem() {
		return listOfSalesOrderItem;
	}

	public void setListOfSalesOrderItem(List<SalesOrderItem> listOfSalesOrderItem) {
		this.listOfSalesOrderItem = listOfSalesOrderItem;
	}

	public SalesOrderStatus getSalesOrderStatus() {
		return salesOrderStatus;
	}

	public void setSalesOrderStatus(SalesOrderStatus salesOrderStatus) {
		this.salesOrderStatus = salesOrderStatus;
	}

	public double getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(double discountValue) {
		this.discountValue = discountValue;
	}

	public double getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}
}
