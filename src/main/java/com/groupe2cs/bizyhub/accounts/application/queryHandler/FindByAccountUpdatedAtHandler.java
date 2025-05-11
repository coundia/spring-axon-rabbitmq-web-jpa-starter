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
public class FindByAccountUpdatedAtHandler {

private final AccountRepository repository;
@QueryHandler
public List<AccountResponse> handle(FindByAccountUpdatedAtQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Account> entities = null;
	 java.time.Instant value = query.getUpdatedAt().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByUpdatedAtAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByUpdatedAtAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(AccountMapper::toResponse)
	.toList();
	}


}
