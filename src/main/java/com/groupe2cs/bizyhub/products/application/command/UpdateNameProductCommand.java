package com.groupe2cs.bizyhub.products.application.command;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateNameProductCommand {
    private ProductId productId;
    private ProductName productName;
}
