package com.groupe2cs.bizyhub.sales.application.command;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateSaleCommand implements Serializable {
    @TargetAggregateIdentifier
    private SaleId id;
    private SaleQuantity quantity;
    private SaleTotal_price total_price;
    private SaleFacture facture;
    private SaleProduct Product;


}
