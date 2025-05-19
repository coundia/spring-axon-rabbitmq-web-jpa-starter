package com.groupe2cs.bizyhub.settings.application.query;

import com.groupe2cs.bizyhub.settings.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindBySettingIdQuery {

	private final SettingId  id;
	private final MetaRequest metaRequest;

}
