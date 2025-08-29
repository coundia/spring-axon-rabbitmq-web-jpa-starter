package com.groupe2cs.bizyhub.stock.domain.exception;

public class StockLevelNotFoundException extends RuntimeException {

	public StockLevelNotFoundException(String object, String value) {
		super("StockLevel with " + object + ": '" + value + "' not found");
	}
}
