package com.groupe2cs.bizyhub.products.domain.exception;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;

public class ProductNotFoundException extends RuntimeException {

	public ProductNotFoundException(String object, String value) {
		super("Product with " + object + ": '" + value + "' not found");
	}
}
