package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import com.groupe2cs.bizyhub.accounts.application.dto.AccountResponse;
import com.groupe2cs.bizyhub.accounts.application.mapper.AccountMapper;
import com.groupe2cs.bizyhub.accounts.application.query.FindByAccountSyncAtQuery;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.Account;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.AccountRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class FindByAccountSyncAtHandler {

	private final AccountRepository repository;

	@QueryHandler
	public List<AccountResponse> handle(FindByAccountSyncAtQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Account> entities = null;
		java.time.Instant value = query.getSyncAt().value();

		if (metaRequest.isAdmin()) {
			log.info("findBySyncAtAndTenantId isAdmin Tenant ID: {}", metaRequest.getTenantId());
			entities = repository.findBySyncAtAndTenantId(value, metaRequest.getTenantId());
		} else {

			log.info("findBySyncAtAndCreatedById not admin User ID: {}", metaRequest.getUserId());
			entities = repository.findBySyncAtAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(AccountMapper::toResponse)
				.toList();
	}


}
