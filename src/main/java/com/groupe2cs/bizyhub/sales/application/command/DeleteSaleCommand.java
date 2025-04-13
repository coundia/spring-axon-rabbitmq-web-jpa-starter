package com.groupe2cs.bizyhub.sales.application.command;

import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeleteSaleCommand implements Serializable {
    @TargetAggregateIdentifier
    private SaleId id;
}
