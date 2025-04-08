package com.groupe2cs.bizyhub.sales.application.query;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

public class FindByIdSaleQuery {

private final SaleId  id;

public FindByIdSaleQuery( SaleId id) {
	this.id = id;
}

public SaleId  getId() {
return id;
}
}
