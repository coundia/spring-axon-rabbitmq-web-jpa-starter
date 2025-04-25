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
public class FindByTransactionIdHandler {

private final TransactionRepository repository;
@QueryHandler

 public TransactionResponse handle(FindByTransactionIdQuery query) {
	String value = query.getId().value();
	Transaction entity = repository.findById(value)
		.orElse(null);

		if (entity == null) {
			return null;
		}

		return TransactionMapper.toResponse(entity);
	}

}
