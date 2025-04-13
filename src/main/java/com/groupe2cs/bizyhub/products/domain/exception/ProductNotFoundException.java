package com.groupe2cs.bizyhub.products.domain.exception;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(ProductId id) {
        super("Product with ID " + id + " not found");
    }
}
