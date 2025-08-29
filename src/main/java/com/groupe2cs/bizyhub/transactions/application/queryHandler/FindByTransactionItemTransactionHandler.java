package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionItemMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionItemTransactionQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItem;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionItemRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByTransactionItemTransactionHandler {

	private final TransactionItemRepository repository;

	@QueryHandler
	public List<TransactionItemResponse> handle(FindByTransactionItemTransactionQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<TransactionItem> entities = null;
		String value = query.getTransaction().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByTransactionAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByTransactionAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(TransactionItemMapper::toResponse)
				.toList();
	}


}
