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
public class FindByStockMovementOrderLineIdHandler {

private final StockMovementRepository repository;

@QueryHandler
public List<StockMovementResponse> handle(FindByStockMovementOrderLineIdQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<StockMovement> entities = null;
	 String value = query.getOrderLineId().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByOrderLineIdAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByOrderLineIdAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(StockMovementMapper::toResponse)
	.toList();
	}


}
