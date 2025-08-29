package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserPagedResponse;
import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountUserMapper;
import com.groupe2cs.bizyhub.accounts.application.query.FindAllAccountUserQuery;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUser;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountUserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllAccountUserQueryHandler {

	private final AccountUserRepository repository;

	public FindAllAccountUserQueryHandler(AccountUserRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public AccountUserPagedResponse handle(FindAllAccountUserQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<AccountUser> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all AccountUsers");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<AccountUserResponse> responses = pages.stream()
				.map(AccountUserMapper::toResponse)
				.toList();

		return AccountUserPagedResponse.from(
				pages,
				responses
		);
	}
}
