package com.groupe2cs.bizyhub.products.application.query;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;

public class FindByProductIdQuery {

private final ProductId  id;

public FindByProductIdQuery( ProductId id) {
	this.id = id;
}

public ProductId  getId() {
return id;
}
}
