package com.groupe2cs.bizyhub.sync.application.query;

import com.groupe2cs.bizyhub.sync.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByChangeLogEntityIdQuery {

	private final ChangeLogEntityId  entityId;
	private final MetaRequest metaRequest;

}
