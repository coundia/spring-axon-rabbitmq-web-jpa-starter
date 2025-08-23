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
public class FindAllTransactionEntryQueryHandler {

private final TransactionEntryRepository repository;

public FindAllTransactionEntryQueryHandler(TransactionEntryRepository repository) {
	this.repository = repository;
}

@QueryHandler
public TransactionEntryPagedResponse handle(FindAllTransactionEntryQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<TransactionEntry> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all TransactionEntrys");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<TransactionEntryResponse> responses = pages.stream()
	.map(TransactionEntryMapper::toResponse)
	.toList();

	return TransactionEntryPagedResponse.from(
	pages,
	responses
	);
	}
}
