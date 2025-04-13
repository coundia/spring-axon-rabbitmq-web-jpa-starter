package com.groupe2cs.bizyhub.sales.application.query;

import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleQuantity;

public class FindBySaleQuantityQuery {

    private final SaleQuantity quantity;

    public FindBySaleQuantityQuery(SaleQuantity quantity) {
        this.quantity = quantity;
    }

    public SaleQuantity getQuantity() {
        return quantity;
    }
}
