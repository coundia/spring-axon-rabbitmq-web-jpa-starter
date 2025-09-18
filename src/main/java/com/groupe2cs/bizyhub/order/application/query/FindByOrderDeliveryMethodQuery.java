package com.groupe2cs.bizyhub.order.application.query;

import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByOrderDeliveryMethodQuery {

	private final OrderDeliveryMethod  deliveryMethod;
	private final MetaRequest metaRequest;

}
