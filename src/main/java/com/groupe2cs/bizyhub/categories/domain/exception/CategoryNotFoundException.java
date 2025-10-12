package com.groupe2cs.bizyhub.categories.domain.exception;

import com.groupe2cs.bizyhub.categories.domain.valueObject.CategoryId;

public class CategoryNotFoundException extends RuntimeException {

	public CategoryNotFoundException(String object, String value) {
		super("Category with " + object + ": '" + value + "' not found");
	}
}
