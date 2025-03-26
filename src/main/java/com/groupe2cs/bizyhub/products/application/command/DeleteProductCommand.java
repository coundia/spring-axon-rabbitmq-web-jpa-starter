package com.groupe2cs.bizyhub.products.application.command;


import com.groupe2cs.bizyhub.products.domain.valueObject.ProductId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Getter
@AllArgsConstructor
public class DeleteProductCommand {
    @TargetAggregateIdentifier
    private ProductId productId;
}
