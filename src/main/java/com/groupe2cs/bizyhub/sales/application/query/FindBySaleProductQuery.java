package com.groupe2cs.bizyhub.sales.application.query;

import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleProduct;

public class FindBySaleProductQuery {

    private final SaleProduct Product;

    public FindBySaleProductQuery(SaleProduct Product) {
        this.Product = Product;
    }

    public SaleProduct getProduct() {
        return Product;
    }
}
