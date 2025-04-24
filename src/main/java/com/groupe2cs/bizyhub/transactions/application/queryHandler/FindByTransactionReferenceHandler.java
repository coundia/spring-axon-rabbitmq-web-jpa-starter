package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionReferenceQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByTransactionReferenceHandler {

	private final TransactionRepository repository;

	@QueryHandler

	public TransactionResponse handle(FindByTransactionReferenceQuery query) {
		String value = query.getReference().value();
		Transaction entity = repository.findByReference(value)
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return TransactionMapper.toResponse(entity);
	}

}
