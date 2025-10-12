package com.groupe2cs.bizyhub.categories.application.query;

import com.groupe2cs.bizyhub.categories.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByCategoryLocalIdQuery {

	private final CategoryLocalId localId;
	private final MetaRequest metaRequest;

}
