package com.groupe2cs.bizyhub.stock.application.query;

import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByStockLevelCompanyQuery {

	private final StockLevelCompany  company;
	private final MetaRequest metaRequest;

}
