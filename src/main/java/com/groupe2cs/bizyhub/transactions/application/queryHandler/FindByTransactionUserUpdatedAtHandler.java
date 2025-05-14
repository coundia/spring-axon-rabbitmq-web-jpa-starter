package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionUserMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionUserUpdatedAtQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionUser;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionUserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByTransactionUserUpdatedAtHandler {

	private final TransactionUserRepository repository;

	@QueryHandler
	public List<TransactionUserResponse> handle(FindByTransactionUserUpdatedAtQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<TransactionUser> entities = null;
		java.time.Instant value = query.getUpdatedAt().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByUpdatedAtAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByUpdatedAtAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(TransactionUserMapper::toResponse)
				.toList();
	}


}
