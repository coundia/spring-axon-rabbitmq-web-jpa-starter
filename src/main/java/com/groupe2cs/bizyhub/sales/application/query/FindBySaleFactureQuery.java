package com.groupe2cs.bizyhub.sales.application.query;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

public class FindBySaleFactureQuery {

private final SaleFacture  facture;

public FindBySaleFactureQuery( SaleFacture facture) {
	this.facture = facture;
}

public SaleFacture  getFacture() {
return facture;
}
}
