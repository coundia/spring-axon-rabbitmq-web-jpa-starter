package com.groupe2cs.bizyhub.sales.application.command;

import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleFacture;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleQuantity;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleTotal_price;
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

    public CreateSaleCommand(
            SaleQuantity quantity, SaleTotal_price total_price, SaleFacture facture) {
        this.id = SaleId.create(UUID.randomUUID().toString());

        this.quantity = quantity;
        this.total_price = total_price;
        this.facture = facture;
    }
}
