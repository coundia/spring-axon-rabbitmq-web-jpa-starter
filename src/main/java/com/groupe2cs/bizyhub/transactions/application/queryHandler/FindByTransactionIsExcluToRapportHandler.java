package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionIsExcluToRapportQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.Transaction;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByTransactionIsExcluToRapportHandler {

	private final TransactionRepository repository;

	@QueryHandler
	public List<TransactionResponse> handle(FindByTransactionIsExcluToRapportQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		Boolean value = query.getIsExcluToRapport().value();
		List<Transaction> entities = repository.findByIsExcluToRapportAndCreatedById(value, metaRequest.getUserId());
		return entities.stream()
				.map(TransactionMapper::toResponse)
				.toList();
	}


}
