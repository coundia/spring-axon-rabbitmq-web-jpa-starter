package com.groupe2cs.bizyhub.companies.application.query;

import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyPhone;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByCompanyPhoneQuery {

	private final CompanyPhone phone;
	private final MetaRequest metaRequest;

}
