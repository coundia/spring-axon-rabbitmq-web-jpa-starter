package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountPagedResponse;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountMapper;
import com.groupe2cs.bizyhub.accounts.application.query.FindAllAccountQuery;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllAccountQueryHandler {

	private final AccountRepository repository;

	public FindAllAccountQueryHandler(AccountRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public AccountPagedResponse handle(FindAllAccountQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Account> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Accounts");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<AccountResponse> responses = pages.stream()
				.map(AccountMapper::toResponse)
				.toList();

		return AccountPagedResponse.from(
				pages,
				responses
		);
	}
}
