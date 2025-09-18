package com.groupe2cs.bizyhub.order.application.query;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByOrderMailQuery {

	private final OrderMail  mail;
	private final MetaRequest metaRequest;

}
