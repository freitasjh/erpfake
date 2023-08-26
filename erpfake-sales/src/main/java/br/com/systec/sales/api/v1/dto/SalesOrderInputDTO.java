package br.com.systec.sales.api.v1.dto;

import java.util.List;

import br.com.systec.sales.enums.SalesOrderStatus;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
public class SalesOrderInputDTO {

	private Long id;
	private Long clientId;
	private String clientName;
	private double salesOrderValue;
	private double discountValue;
	private double discountPercent;
	private double quantityTotal;
	private List<SalesOrderItemDTO> listOfSalesOrderItem;
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

	public List<SalesOrderItemDTO> getListOfSalesOrderItem() {
		return listOfSalesOrderItem;
	}

	public void setListOfSalesOrderItem(List<SalesOrderItemDTO> listOfSalesOrderItem) {
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
