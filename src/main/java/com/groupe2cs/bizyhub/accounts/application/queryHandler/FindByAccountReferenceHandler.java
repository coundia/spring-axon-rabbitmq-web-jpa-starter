package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountMapper;
import com.groupe2cs.bizyhub.accounts.application.query.FindByAccountReferenceQuery;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByAccountReferenceHandler {

	private final AccountRepository repository;

	@QueryHandler
	public List<AccountResponse> handle(FindByAccountReferenceQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Account> entities = null;
		String value = query.getReference().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByReferenceAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByReferenceAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(AccountMapper::toResponse)
				.toList();
	}


}
