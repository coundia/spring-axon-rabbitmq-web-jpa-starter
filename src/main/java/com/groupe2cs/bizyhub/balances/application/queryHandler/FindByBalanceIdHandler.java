package com.groupe2cs.bizyhub.balances.application.queryHandler;

import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.application.mapper.BalanceMapper;
import com.groupe2cs.bizyhub.balances.application.query.FindByBalanceIdQuery;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.Balance;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.BalanceRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindByBalanceIdHandler {

	private final BalanceRepository repository;

	@QueryHandler

	public BalanceResponse handle(FindByBalanceIdQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();

		String value = query.getId().value();
		Balance entity = repository.findByIdAndCreatedById(value, metaRequest.getUserId())
				.orElse(null);

		if (entity == null) {
			return null;
		}

		return BalanceMapper.toResponse(entity);
	}

}
