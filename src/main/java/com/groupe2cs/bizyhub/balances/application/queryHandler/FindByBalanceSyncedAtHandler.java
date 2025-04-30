package com.groupe2cs.bizyhub.balances.application.queryHandler;

import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.application.mapper.BalanceMapper;
import com.groupe2cs.bizyhub.balances.application.query.FindByBalanceSyncedAtQuery;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByBalanceSyncedAtHandler {

	private final BalanceRepository repository;

	@QueryHandler
	public List<BalanceResponse> handle(FindByBalanceSyncedAtQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		java.time.Instant value = query.getSyncedAt().value();
		List<Balance> entities = repository.findBySyncedAtAndCreatedById(value, metaRequest.getUserId());
		return entities.stream()
				.map(BalanceMapper::toResponse)
				.toList();
	}


}
