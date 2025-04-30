package com.groupe2cs.bizyhub.balances.application.queryHandler;

import com.groupe2cs.bizyhub.balances.application.dto.BalancePagedResponse;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.application.mapper.BalanceMapper;
import com.groupe2cs.bizyhub.balances.application.query.FindAllBalanceQuery;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllBalanceQueryHandler {

	private final BalanceRepository repository;

	public FindAllBalanceQueryHandler(BalanceRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public BalancePagedResponse handle(FindAllBalanceQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Balance> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Balances");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {
			log.info("Non-admin user, fetching Balances by userId");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);
		}

		List<BalanceResponse> responses = pages.stream()
				.map(BalanceMapper::toResponse)
				.toList();

		return BalancePagedResponse.from(
				pages,
				responses
		);
	}
}
