package br.com.systec.sales.amqp.dto;

import java.util.Date;
import java.util.List;

public class StockOrderDTO {

	private Long orderId;
	private Date dateOrderFinalize;
	private String transactionType;
	private List<StockOrderItemDTO> listOfSalesOrderItem;
	
	public StockOrderDTO() {
		this.transactionType = "OUT";
	}
	
	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getDateOrderFinalize() {
		return dateOrderFinalize;
	}

	public void setDateOrderFinalize(Date dateOrderFinalize) {
		this.dateOrderFinalize = dateOrderFinalize;
	}

	public String getTransactionType() {
		return transactionType;
	}
	
	public List<StockOrderItemDTO> getListOfSalesOrderItem() {
		return listOfSalesOrderItem;
	}

	public void setListOfSalesOrderItem(List<StockOrderItemDTO> listOfSalesOrderItem) {
		this.listOfSalesOrderItem = listOfSalesOrderItem;
	}

}
