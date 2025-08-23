package com.groupe2cs.bizyhub.stock.application.query;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByStockMovementCompanyQuery {

	private final StockMovementCompany  company;
	private final MetaRequest metaRequest;

}
