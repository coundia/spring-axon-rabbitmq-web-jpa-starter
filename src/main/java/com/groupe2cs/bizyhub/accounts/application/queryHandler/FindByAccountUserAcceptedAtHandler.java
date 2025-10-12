package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountUserMapper;
import com.groupe2cs.bizyhub.accounts.application.query.FindByAccountUserAcceptedAtQuery;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUser;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountUserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByAccountUserAcceptedAtHandler {

	private final AccountUserRepository repository;

	@QueryHandler
	public List<AccountUserResponse> handle(FindByAccountUserAcceptedAtQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<AccountUser> entities = null;
		java.time.Instant value = query.getAcceptedAt().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByAcceptedAtAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByAcceptedAtAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(AccountUserMapper::toResponse)
				.toList();
	}


}
