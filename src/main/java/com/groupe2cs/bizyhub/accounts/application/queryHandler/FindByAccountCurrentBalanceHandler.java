package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountMapper;
import com.groupe2cs.bizyhub.accounts.application.query.FindByAccountCurrentBalanceQuery;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByAccountCurrentBalanceHandler {

	private final AccountRepository repository;

	@QueryHandler
	public List<AccountResponse> handle(FindByAccountCurrentBalanceQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Account> entities = null;
		Double value = query.getCurrentBalance().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByCurrentBalanceAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByCurrentBalanceAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(AccountMapper::toResponse)
				.toList();
	}


}
