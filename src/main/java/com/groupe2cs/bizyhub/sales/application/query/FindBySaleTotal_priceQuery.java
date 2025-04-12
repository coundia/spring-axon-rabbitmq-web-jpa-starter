package com.groupe2cs.bizyhub.sales.application.query;

import com.groupe2cs.bizyhub.sales.domain.valueObject.*;

public class FindBySaleTotal_priceQuery {

private final SaleTotal_price  total_price;

public FindBySaleTotal_priceQuery( SaleTotal_price total_price) {
	this.total_price = total_price;
}

public SaleTotal_price  getTotal_price() {
return total_price;
}
}
