package br.com.systec.sales.api.v1.dto;

import br.com.systec.sales.enums.SalesOrderStatus;

public class SalesOrderDTO {

	private Long id;
	private Long clientId;
	private String clientName;
	private double quantity;
	private double salesOrderValue;
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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getSalesOrderValue() {
		return salesOrderValue;
	}

	public void setSalesOrderValue(double salesOrderValue) {
		this.salesOrderValue = salesOrderValue;
	}

	public SalesOrderStatus getSalesOrderStatus() {
		return salesOrderStatus;
	}

	public void setSalesOrderStatus(SalesOrderStatus salesOrderStatus) {
		this.salesOrderStatus = salesOrderStatus;
	}

}
