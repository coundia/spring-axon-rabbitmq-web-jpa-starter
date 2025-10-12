package com.groupe2cs.bizyhub.sync.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.domain.valueObject.SyncStateTenant;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindBySyncStateTenantQuery {

	private final SyncStateTenant tenant;
	private final MetaRequest metaRequest;

}
