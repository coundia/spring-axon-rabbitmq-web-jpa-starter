package com.groupe2cs.bizyhub.customers.application.query;

import com.groupe2cs.bizyhub.customers.domain.valueObject.CustomerCompany;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByCustomerCompanyQuery {

	private final CustomerCompany company;
	private final MetaRequest metaRequest;

}
