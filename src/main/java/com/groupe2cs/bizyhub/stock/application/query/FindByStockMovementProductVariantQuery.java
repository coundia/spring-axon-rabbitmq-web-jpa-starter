package com.groupe2cs.bizyhub.stock.application.query;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.stock.domain.valueObject.StockMovementProductVariant;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@Builder
public class FindByStockMovementProductVariantQuery {

	private final StockMovementProductVariant productVariant;
	private final MetaRequest metaRequest;

}
