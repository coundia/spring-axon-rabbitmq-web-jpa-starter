package com.groupe2cs.bizyhub.debts.application.queryHandler;

import com.groupe2cs.bizyhub.debts.application.dto.DebtResponse;
import com.groupe2cs.bizyhub.debts.application.mapper.DebtMapper;
import com.groupe2cs.bizyhub.debts.application.query.FindByDebtBalanceDebtQuery;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.Debt;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.DebtRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByDebtBalanceDebtHandler {

	private final DebtRepository repository;

	@QueryHandler
	public List<DebtResponse> handle(FindByDebtBalanceDebtQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Debt> entities = null;
		Double value = query.getBalanceDebt().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByBalanceDebtAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByBalanceDebtAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(DebtMapper::toResponse)
				.toList();
	}


}
