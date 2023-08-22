package br.com.systec.purchase.api.v1.dto;

public class PurchaseItemDTO {

	private Long id;
	private Long productId;
	private String productDescription;
	private double quantity;
	private double unitaryValue;
	private double amount;

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

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getUnitaryValue() {
		return unitaryValue;
	}

	public void setUnitaryValue(double unitaryValue) {
		this.unitaryValue = unitaryValue;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
}
