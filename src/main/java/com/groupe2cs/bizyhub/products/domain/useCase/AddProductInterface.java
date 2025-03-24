package com.groupe2cs.bizyhub.products.domain.useCase;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;

public interface AddProductInterface {
    void addProduct(ProductPrice price, ProductName name);
}
