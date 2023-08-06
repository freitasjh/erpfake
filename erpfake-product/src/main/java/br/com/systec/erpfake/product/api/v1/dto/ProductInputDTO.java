package br.com.systec.erpfake.product.api.v1.dto;

import java.io.Serializable;

/**
 * 
 * @author JOAO HENRIQUE FREITAS
 *
 */
public class ProductInputDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String code;
	private String codEan;
	private String description;
	private double price;
	private Double quantity;

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

	public String getCodEan() {
		return codEan;
	}

	public void setCodEan(String codEan) {
		this.codEan = codEan;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getQuantity() {
		return quantity;
	}

	@Override
	public String toString() {
		return "ProductInputDTO [id=" + id + ", code=" + code + ", codEan=" + codEan + ", description=" + description
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}

}
