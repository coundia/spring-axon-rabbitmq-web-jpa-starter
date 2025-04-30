package com.groupe2cs.bizyhub.balances.application.queryHandler;

import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.application.mapper.BalanceMapper;
import com.groupe2cs.bizyhub.balances.application.query.FindByBalanceActivateNotificationQuery;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FindByBalanceActivateNotificationHandler {

	private final BalanceRepository repository;

	@QueryHandler
	public List<BalanceResponse> handle(FindByBalanceActivateNotificationQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		Boolean value = query.getActivateNotification().value();
		List<Balance> entities = repository.findByActivateNotificationAndCreatedById(value, metaRequest.getUserId());
		return entities.stream()
				.map(BalanceMapper::toResponse)
				.toList();
	}


}
