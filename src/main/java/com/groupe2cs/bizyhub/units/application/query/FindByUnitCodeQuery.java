package com.groupe2cs.bizyhub.units.application.query;

import com.groupe2cs.bizyhub.units.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByUnitCodeQuery {

	private final UnitCode  code;
	private final MetaRequest metaRequest;

}
