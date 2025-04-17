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
public class FindByTransactionsIdHandler {

private final TransactionsRepository repository;
@QueryHandler
 public TransactionsResponse handle(FindByTransactionsIdQuery query) {
	String value = query.getId().value();
	Transactions entity = repository.findById(value)
		.orElseThrow(() -> new TransactionsNotFoundException(query.getId()));
		return TransactionsMapper.toResponse(entity);
	}

}
