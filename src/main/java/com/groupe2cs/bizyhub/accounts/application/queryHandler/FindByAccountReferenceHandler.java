package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.accounts.application.query.*;
import com.groupe2cs.bizyhub.accounts.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByAccountReferenceHandler {

private final AccountRepository repository;
@QueryHandler
public List<AccountResponse> handle(FindByAccountReferenceQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Account> entities = null;
	 String value = query.getReference().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByReferenceAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByReferenceAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(AccountMapper::toResponse)
	.toList();
	}


}
