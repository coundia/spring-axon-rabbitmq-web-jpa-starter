package com.groupe2cs.bizyhub.message.application.query;

import com.groupe2cs.bizyhub.message.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByMessageDescriptionQuery {

	private final MessageDescription  description;
	private final MetaRequest metaRequest;

}
