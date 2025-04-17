package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Component
public class FindAllTransactionsQueryHandler {

private final TransactionsRepository repository;

public FindAllTransactionsQueryHandler(TransactionsRepository repository) {
	this.repository = repository;
}

@QueryHandler
public TransactionsPagedResponse handle(FindAllTransactionsQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;

long totalElements = repository.count();

PageRequest pageable = PageRequest.of(offset / limit, limit);

Page<Transactions> pages = repository.findAll(pageable);

List<TransactionsResponse> responses = pages.stream()
	.map(TransactionsMapper::toResponse)
	.toList();

	return TransactionsPagedResponse.from(
	pages,
	responses
	);
	}
}
