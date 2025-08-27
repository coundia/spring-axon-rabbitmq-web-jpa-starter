package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllTransactionUserQueryHandler {

private final TransactionUserRepository repository;

public FindAllTransactionUserQueryHandler(TransactionUserRepository repository) {
	this.repository = repository;
}

@QueryHandler
public TransactionUserPagedResponse handle(FindAllTransactionUserQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<TransactionUser> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all TransactionUsers");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<TransactionUserResponse> responses = pages.stream()
	.map(TransactionUserMapper::toResponse)
	.toList();

	return TransactionUserPagedResponse.from(
	pages,
	responses
	);
	}
}
