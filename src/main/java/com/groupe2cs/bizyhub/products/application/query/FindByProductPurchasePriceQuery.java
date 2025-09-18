package com.groupe2cs.bizyhub.products.application.query;

import com.groupe2cs.bizyhub.products.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByProductPurchasePriceQuery {

	private final ProductPurchasePrice  purchasePrice;
	private final MetaRequest metaRequest;

}
