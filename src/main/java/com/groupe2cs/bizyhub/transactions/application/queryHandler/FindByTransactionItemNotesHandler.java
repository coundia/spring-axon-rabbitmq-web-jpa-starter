package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionItemMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionItemNotesQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItem;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionItemRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByTransactionItemNotesHandler {

	private final TransactionItemRepository repository;

	@QueryHandler
	public List<TransactionItemResponse> handle(FindByTransactionItemNotesQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<TransactionItem> entities = null;
		String value = query.getNotes().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByNotesAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByNotesAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(TransactionItemMapper::toResponse)
				.toList();
	}


}
