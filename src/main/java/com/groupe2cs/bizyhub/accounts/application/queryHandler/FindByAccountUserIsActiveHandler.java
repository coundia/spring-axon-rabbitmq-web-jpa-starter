package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountUserMapper;
import com.groupe2cs.bizyhub.accounts.application.query.FindByAccountUserIsActiveQuery;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUser;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountUserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByAccountUserIsActiveHandler {

	private final AccountUserRepository repository;

	@QueryHandler
	public List<AccountUserResponse> handle(FindByAccountUserIsActiveQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<AccountUser> entities = null;
		Boolean value = query.getIsActive().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByIsActiveAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByIsActiveAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(AccountUserMapper::toResponse)
				.toList();
	}


}
