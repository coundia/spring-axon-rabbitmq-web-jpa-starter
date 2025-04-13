package com.groupe2cs.bizyhub.products.application.query;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;

public class FindByProductPriceQuery {

    private final ProductPrice price;

    public FindByProductPriceQuery(ProductPrice price) {
        this.price = price;
    }

    public ProductPrice getPrice() {
        return price;
    }
}
