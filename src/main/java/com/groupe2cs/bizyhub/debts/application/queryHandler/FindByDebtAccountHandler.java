package com.groupe2cs.bizyhub.debts.application.queryHandler;

import com.groupe2cs.bizyhub.debts.application.mapper.*;
import com.groupe2cs.bizyhub.debts.domain.valueObject.*;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.debts.application.query.*;
import com.groupe2cs.bizyhub.debts.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import org.axonframework.queryhandling.QueryHandler;



@Component
@RequiredArgsConstructor
public class FindByDebtAccountHandler {

private final DebtRepository repository;

@QueryHandler
public List<DebtResponse> handle(FindByDebtAccountQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Debt> entities = null;
	 String value = query.getAccount().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByAccountAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByAccountAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(DebtMapper::toResponse)
	.toList();
	}


}
