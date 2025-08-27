package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByTransactionItemTotalHandler {

private final TransactionItemRepository repository;

@QueryHandler
public List<TransactionItemResponse> handle(FindByTransactionItemTotalQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<TransactionItem> entities = null;
	 Double value = query.getTotal().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByTotalAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByTotalAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(TransactionItemMapper::toResponse)
	.toList();
	}


}
