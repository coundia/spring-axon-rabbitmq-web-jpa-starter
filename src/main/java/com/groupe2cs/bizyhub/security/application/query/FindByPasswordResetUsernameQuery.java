package com.groupe2cs.bizyhub.security.application.query;

import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByPasswordResetUsernameQuery {

	private final PasswordResetUsername  username;
	private final MetaRequest metaRequest;

}
