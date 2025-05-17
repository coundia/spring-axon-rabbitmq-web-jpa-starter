package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountUserResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountUserMapper;
import com.groupe2cs.bizyhub.accounts.application.query.FindByAccountUserUserQuery;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.AccountUser;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountUserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByAccountUserUserHandler {

	private final AccountUserRepository repository;

	@QueryHandler
	public List<AccountUserResponse> handle(FindByAccountUserUserQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<AccountUser> entities = null;
		String value = query.getUser().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByUserIdAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByUserIdAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(AccountUserMapper::toResponse)
				.toList();
	}


}
