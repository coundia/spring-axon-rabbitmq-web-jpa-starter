package com.groupe2cs.bizyhub.transactions.application.queryHandler;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserPagedResponse;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionUserMapper;
import com.groupe2cs.bizyhub.transactions.application.query.FindAllTransactionUserQuery;
import com.groupe2cs.bizyhub.transactions.infrastructure.entity.TransactionUser;
import com.groupe2cs.bizyhub.transactions.infrastructure.repository.TransactionUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllTransactionUserQueryHandler {

	private final TransactionUserRepository repository;

	public FindAllTransactionUserQueryHandler(TransactionUserRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public TransactionUserPagedResponse handle(FindAllTransactionUserQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<TransactionUser> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all TransactionUsers");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {
			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);
		}

		List<TransactionUserResponse> responses = pages.stream()
				.map(TransactionUserMapper::toResponse)
				.toList();

		return TransactionUserPagedResponse.from(
				pages,
				responses
		);
	}
}
