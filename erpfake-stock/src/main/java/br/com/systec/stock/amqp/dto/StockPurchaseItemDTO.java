package br.com.systec.stock.amqp.dto;

public class StockPurchaseItemDTO {

	private Long productId;
	private double quantity;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
}
