package com.groupe2cs.bizyhub.stock.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockLevelAccount;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByStockLevelAccountQuery {

	private final StockLevelAccount account;
	private final MetaRequest metaRequest;

}
