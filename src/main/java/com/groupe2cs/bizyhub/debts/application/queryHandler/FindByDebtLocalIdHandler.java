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
public class FindByDebtLocalIdHandler {

private final DebtRepository repository;

@QueryHandler
public List<DebtResponse> handle(FindByDebtLocalIdQuery query) {

	 MetaRequest metaRequest = query.getMetaRequest();
	 List<Debt> entities = null;
	 String value = query.getLocalId().value();

	 if(metaRequest.isAdmin()) {
	    entities = repository.findByLocalIdAndTenantId(value, metaRequest.getTenantId());
	 }else{
	    entities = repository.findByLocalIdAndCreatedById(value, metaRequest.getUserId());
	 }

 	return entities.stream()
	.map(DebtMapper::toResponse)
	.toList();
	}


}
