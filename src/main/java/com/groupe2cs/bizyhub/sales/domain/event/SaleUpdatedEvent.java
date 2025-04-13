package com.groupe2cs.bizyhub.sales.domain.event;

import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleFacture;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleId;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleQuantity;
import com.groupe2cs.bizyhub.sales.domain.valueObject.SaleTotal_price;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleUpdatedEvent implements Serializable {

    private SaleId id;
    private SaleQuantity quantity;
    private SaleTotal_price total_price;
    private SaleFacture facture;
}
