package com.groupe2cs.bizyhub.tenant.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantDescription;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByTenantDescriptionQuery {

	private final TenantDescription description;
	private final MetaRequest metaRequest;

}
