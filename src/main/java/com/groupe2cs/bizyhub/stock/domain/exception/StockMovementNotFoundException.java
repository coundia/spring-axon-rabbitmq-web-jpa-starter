package com.groupe2cs.bizyhub.stock.domain.exception;

public class StockMovementNotFoundException extends RuntimeException {

	public StockMovementNotFoundException(String object, String value) {
		super("StockMovement with " + object + ": '" + value + "' not found");
	}
}
