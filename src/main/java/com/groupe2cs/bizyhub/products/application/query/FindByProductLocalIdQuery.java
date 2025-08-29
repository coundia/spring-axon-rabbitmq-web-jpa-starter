package com.groupe2cs.bizyhub.products.application.query;

import com.groupe2cs.bizyhub.products.domain.valueObject.ProductLocalId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByProductLocalIdQuery {

	private final ProductLocalId localId;
	private final MetaRequest metaRequest;

}
