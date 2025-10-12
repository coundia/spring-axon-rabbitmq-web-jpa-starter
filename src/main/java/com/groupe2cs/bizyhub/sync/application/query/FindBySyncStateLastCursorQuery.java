package com.groupe2cs.bizyhub.sync.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.sync.domain.valueObject.SyncStateLastCursor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindBySyncStateLastCursorQuery {

	private final SyncStateLastCursor lastCursor;
	private final MetaRequest metaRequest;

}
