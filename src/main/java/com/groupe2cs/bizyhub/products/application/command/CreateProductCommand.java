package com.groupe2cs.bizyhub.products.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Getter
@AllArgsConstructor
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String id;
    private Double price;
    private String name;
}
