package com.groupe2cs.bizyhub.sync.application.query;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindBySyncStateSyncAtQuery {

	private final SyncStateSyncAt  syncAt;
	private final MetaRequest metaRequest;

}
