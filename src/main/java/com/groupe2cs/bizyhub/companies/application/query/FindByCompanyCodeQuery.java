package com.groupe2cs.bizyhub.companies.application.query;

import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByCompanyCodeQuery {

	private final CompanyCode  code;
	private final MetaRequest metaRequest;

}
