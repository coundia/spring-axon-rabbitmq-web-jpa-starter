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
public class FindByTransactionItemLabelHandler {

private final TransactionItemRepository repository;

@QueryHandler
public List<TransactionItemResponse> handle(FindByTransactionItemLabelQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<TransactionItem> entities = null;
	 String value = query.getLabel().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByLabelAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByLabelAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(TransactionItemMapper::toResponse)
	.toList();
	}


}
