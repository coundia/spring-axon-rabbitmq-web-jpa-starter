package com.groupe2cs.bizyhub.order.application.query;

import com.groupe2cs.bizyhub.order.domain.valueObject.OrderAddress;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByOrderAddressQuery {

	private final OrderAddress address;
	private final MetaRequest metaRequest;

}
