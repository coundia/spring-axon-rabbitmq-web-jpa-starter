package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionAmountQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByTransactionAmountHandler {

	private final TransactionRepository repository;

	@QueryHandler
	public List<TransactionResponse> handle(FindByTransactionAmountQuery query) {
		Double value = query.getAmount().value();
		List<Transaction> entities = repository.findByAmount(value);
		return entities.stream()
				.map(TransactionMapper::toResponse)
				.toList();
	}

}
