package com.groupe2cs.bizyhub.order.application.queryHandler;

import com.groupe2cs.bizyhub.order.application.mapper.*;
import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import com.groupe2cs.bizyhub.order.infrastructure.entity.*;
import com.groupe2cs.bizyhub.order.application.dto.*;
import com.groupe2cs.bizyhub.order.infrastructure.repository.*;
import com.groupe2cs.bizyhub.order.application.query.*;
import com.groupe2cs.bizyhub.order.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByOrderRemoteIdHandler {

private final OrderRepository repository;

@QueryHandler
public List<OrderResponse> handle(FindByOrderRemoteIdQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Order> entities = null;
	 String value = query.getRemoteId().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByRemoteIdAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByRemoteIdAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(OrderMapper::toResponse)
	.toList();
	}


}
