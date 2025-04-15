package com.groupe2cs.bizyhub.products.application.command;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductName;
import com.groupe2cs.bizyhub.products.domain.valueObject.ProductPrice;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProductCommand implements Serializable {
    @TargetAggregateIdentifier
    private ProductId id;
    private ProductName name;
    private ProductPrice price;


}
