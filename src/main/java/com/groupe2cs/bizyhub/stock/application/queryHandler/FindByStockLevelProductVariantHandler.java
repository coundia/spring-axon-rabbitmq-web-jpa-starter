package com.groupe2cs.bizyhub.stock.application.queryHandler;

import com.groupe2cs.bizyhub.stock.application.mapper.*;
import com.groupe2cs.bizyhub.stock.domain.valueObject.*;
import com.groupe2cs.bizyhub.stock.infrastructure.entity.*;
import com.groupe2cs.bizyhub.stock.application.dto.*;
import com.groupe2cs.bizyhub.stock.infrastructure.repository.*;
import com.groupe2cs.bizyhub.stock.application.query.*;
import com.groupe2cs.bizyhub.stock.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByStockLevelProductVariantHandler {

private final StockLevelRepository repository;

@QueryHandler
public List<StockLevelResponse> handle(FindByStockLevelProductVariantQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<StockLevel> entities = null;
	 String value = query.getProductVariant().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByProductVariantAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByProductVariantAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(StockLevelMapper::toResponse)
	.toList();
	}


}
