package br.com.systec.stock.enums;

public enum TransactionType {
	INPUT("IN"), OUTPUT("OUT");

	private String code;

	private TransactionType(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static TransactionType valueOfCode(String code) {
		for (TransactionType item : TransactionType.values()) {
			if (item.getCode().equalsIgnoreCase(code)) {
				return item;
			}
		}

		throw new RuntimeException("Tipo de transação não encontrado");
	}

}
