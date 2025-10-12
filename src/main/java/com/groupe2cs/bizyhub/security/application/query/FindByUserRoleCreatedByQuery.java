package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByUserRoleCreatedByQuery {

	private final UserRoleCreatedBy createdBy;
	private final MetaRequest metaRequest;

}
