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
public class FindByTransactionUserUsernameHandler {

private final TransactionUserRepository repository;
@QueryHandler
public List<TransactionUserResponse> handle(FindByTransactionUserUsernameQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<TransactionUser> entities = null;
	 String value = query.getUsername().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByUsernameAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByUsernameAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(TransactionUserMapper::toResponse)
	.toList();
	}


}
