package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionItemMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionItemIdQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionItem;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionItemRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class FindByTransactionItemIdHandler {

	private final TransactionItemRepository repository;

	@QueryHandler

	public TransactionItemResponse handle(FindByTransactionItemIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		TransactionItem entity = null;

		String value = query.getId().value();

		if (metaRequest.isAdmin()) {
			entity = repository.findByIdAndTenantId(value, metaRequest.getTenantId())
					.stream()
					.findFirst()
					.orElse(null);
		} else {
			entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
					.stream()
					.findFirst()
					.orElse(null);
		}

		if (entity == null) {
			return null;
		}
		return TransactionItemMapper.toResponse(entity);
	}

}
