package br.com.systec.purchase.amqp.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockPurchaseDTO {

	private Long purchaeOrderId;
	private Date datePurchaseFinalized;
	private List<StockPurchaseItemDTO> listOfStockPurchaseItem;

	public Long getPurchaeOrderId() {
		return purchaeOrderId;
	}

	public void setPurchaeOrderId(Long purchaeOrderId) {
		this.purchaeOrderId = purchaeOrderId;
	}

	public Date getDatePurchaseFinalized() {
		return datePurchaseFinalized;
	}

	public void setDatePurchaseFinalized(Date datePurchaseFinalized) {
		this.datePurchaseFinalized = datePurchaseFinalized;
	}

	public List<StockPurchaseItemDTO> getListOfStockPurchaseItem() {
		if (listOfStockPurchaseItem == null) {
			listOfStockPurchaseItem = new ArrayList<>();
		}
		return listOfStockPurchaseItem;
	}

	public void setListOfStockPurchaseItem(List<StockPurchaseItemDTO> listOfStockPurchaseItem) {
		this.listOfStockPurchaseItem = listOfStockPurchaseItem;
	}

}
