package com.groupe2cs.bizyhub.sales.application.command;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import lombok.*;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateSaleCommand implements Serializable {
    @TargetAggregateIdentifier
    private SaleId id;
    private SaleQuantity quantity;
    private SaleTotal_price total_price;
    private SaleFacture facture;
    private SaleProduct Product;

    public CreateSaleCommand(

            SaleQuantity quantity,
            SaleTotal_price total_price,
            SaleFacture facture,
            SaleProduct product
    ) {
        this.id = SaleId.create(UUID.randomUUID().toString());

        this.quantity = quantity;
        this.total_price = total_price;
        this.facture = facture;
        this.Product = product;
    }


}
