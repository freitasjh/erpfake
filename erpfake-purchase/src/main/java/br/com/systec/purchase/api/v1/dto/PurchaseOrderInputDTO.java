package br.com.systec.purchase.api.v1.dto;

import java.util.List;

import br.com.systec.purchase.enums.OrderStatus;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
public class PurchaseOrderInputDTO {

	private Long id;
	private String code;
	private double quantity;
	private double amount;
	private double subtotal;
	private List<PurchaseItemDTO> listOfPurchaseItem;
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

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public List<PurchaseItemDTO> getListOfPurchaseItem() {
		return listOfPurchaseItem;
	}

	public void setListOfPurchaseItem(List<PurchaseItemDTO> listOfPurchaseItem) {
		this.listOfPurchaseItem = listOfPurchaseItem;
	}
	
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

}
