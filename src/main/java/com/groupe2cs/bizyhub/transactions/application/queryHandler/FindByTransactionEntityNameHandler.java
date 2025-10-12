package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionEntityNameQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByTransactionEntityNameHandler {

	private final TransactionRepository repository;

	@QueryHandler
	public List<TransactionResponse> handle(FindByTransactionEntityNameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Transaction> entities = null;
		String value = query.getEntityName().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByEntityNameAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByEntityNameAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(TransactionMapper::toResponse)
				.toList();
	}


}
