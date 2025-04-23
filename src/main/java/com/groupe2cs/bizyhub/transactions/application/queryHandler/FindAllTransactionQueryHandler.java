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
public class FindAllTransactionQueryHandler {

private final TransactionRepository repository;

public FindAllTransactionQueryHandler(TransactionRepository repository) {
	this.repository = repository;
}

@QueryHandler
public TransactionPagedResponse handle(FindAllTransactionQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;

long totalElements = repository.count();

PageRequest pageable = PageRequest.of(offset / limit, limit);

Page<Transaction> pages = repository.findAll(pageable);

List<TransactionResponse> responses = pages.stream()
	.map(TransactionMapper::toResponse)
	.toList();

	return TransactionPagedResponse.from(
	pages,
	responses
	);
	}
}
