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
public class FindByTransactionEntryStatusHandler {

private final TransactionEntryRepository repository;

@QueryHandler
public List<TransactionEntryResponse> handle(FindByTransactionEntryStatusQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<TransactionEntry> entities = null;
	 String value = query.getStatus().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByStatusAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByStatusAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(TransactionEntryMapper::toResponse)
	.toList();
	}


}
