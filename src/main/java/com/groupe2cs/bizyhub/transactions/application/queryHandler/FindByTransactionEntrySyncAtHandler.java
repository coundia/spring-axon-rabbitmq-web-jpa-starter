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
public class FindByTransactionEntrySyncAtHandler {

private final TransactionEntryRepository repository;

@QueryHandler
public List<TransactionEntryResponse> handle(FindByTransactionEntrySyncAtQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<TransactionEntry> entities = null;
	 java.time.Instant value = query.getSyncAt().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findBySyncAtAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findBySyncAtAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(TransactionEntryMapper::toResponse)
	.toList();
	}


}
