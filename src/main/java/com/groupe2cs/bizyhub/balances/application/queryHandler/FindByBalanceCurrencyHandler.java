package com.groupe2cs.bizyhub.balances.application.queryHandler;

import com.groupe2cs.bizyhub.balances.application.mapper.*;
import com.groupe2cs.bizyhub.balances.domain.valueObject.*;
import com.groupe2cs.bizyhub.balances.infrastructure.entity.*;
import com.groupe2cs.bizyhub.balances.application.dto.*;
import com.groupe2cs.bizyhub.balances.infrastructure.repository.*;
import com.groupe2cs.bizyhub.balances.application.query.*;
import com.groupe2cs.bizyhub.balances.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;

@Component
@RequiredArgsConstructor
public class FindByBalanceCurrencyHandler {

private final BalanceRepository repository;
@QueryHandler
public List<BalanceResponse> handle(FindByBalanceCurrencyQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Balance> entities = null;
	 String value = query.getCurrency().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByCurrencyAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByCurrencyAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(BalanceMapper::toResponse)
	.toList();
	}


}
