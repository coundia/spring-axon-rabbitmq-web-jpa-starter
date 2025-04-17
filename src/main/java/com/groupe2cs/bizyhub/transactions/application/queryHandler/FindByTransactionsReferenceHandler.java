package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.domain.exception.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByTransactionsReferenceHandler {

private final TransactionsRepository repository;
@QueryHandler
public List<TransactionsResponse> handle(FindByTransactionsReferenceQuery query) {
String value = query.getReference().value();
	List<Transactions> entities = repository.findByReference(value);
	return entities.stream()
	.map(TransactionsMapper::toResponse)
	.toList();
	}

}
