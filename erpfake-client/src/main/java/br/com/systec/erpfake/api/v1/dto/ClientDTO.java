package br.com.systec.erpfake.api.v1.dto;

public class ClientDTO {

	private Long id;
	private String name;
	private String federalId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFederalId() {
		return federalId;
	}

	public void setFederalId(String federalId) {
		this.federalId = federalId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("ClientDTO [id=%s, name=%s, federalId=%s]", id, name, federalId);
	}

	
}
