package com.groupe2cs.bizyhub.units.application.query;

import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByUnitCreatedByQuery {

	private final UnitCreatedBy  createdBy;
	private final MetaRequest metaRequest;

}
