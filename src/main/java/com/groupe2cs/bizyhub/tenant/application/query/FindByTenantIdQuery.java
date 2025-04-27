package com.groupe2cs.bizyhub.tenant.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantId;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByTenantIdQuery {

	private final TenantId id;
	private final MetaRequest metaRequest;

}
