package com.groupe2cs.bizyhub.products.application.query;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;

public class FindByProductNameQuery {

    private final ProductName name;

    public FindByProductNameQuery(ProductName name) {
        this.name = name;
    }

    public ProductName getName() {
        return name;
    }
}
