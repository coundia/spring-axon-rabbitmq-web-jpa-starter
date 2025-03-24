package com.groupe2cs.bizyhub.products.application.query;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GetProductQuery {
    private ProductId id;
}
