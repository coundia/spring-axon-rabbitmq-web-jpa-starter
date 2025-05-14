package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionUserMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindByTransactionUserNameQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionUser;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionUserRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByTransactionUserNameHandler {

	private final TransactionUserRepository repository;

	@QueryHandler
	public List<TransactionUserResponse> handle(FindByTransactionUserNameQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<TransactionUser> entities = null;
		String value = query.getName().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByNameAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByNameAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(TransactionUserMapper::toResponse)
				.toList();
	}


}
