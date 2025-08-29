package com.groupe2cs.bizyhub.companies.application.query;

import com.groupe2cs.bizyhub.companies.domain.valueObject.CompanyName;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByCompanyNameQuery {

	private final CompanyName name;
	private final MetaRequest metaRequest;

}
