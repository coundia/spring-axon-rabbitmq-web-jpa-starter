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
public class FindByTransactionsAmountHandler {

private final TransactionsRepository repository;
@QueryHandler
public List<TransactionsResponse> handle(FindByTransactionsAmountQuery query) {
Double value = query.getAmount().value();
	List<Transactions> entities = repository.findByAmount(value);
	return entities.stream()
	.map(TransactionsMapper::toResponse)
	.toList();
	}

}
