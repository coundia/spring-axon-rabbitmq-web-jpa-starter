package com.groupe2cs.bizyhub.debts.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.debts.application.dto.*;
import com.groupe2cs.bizyhub.debts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.debts.application.query.*;
import com.groupe2cs.bizyhub.debts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.debts.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllDebtQueryHandler {

private final DebtRepository repository;

public FindAllDebtQueryHandler(DebtRepository repository) {
	this.repository = repository;
}

@QueryHandler
public DebtPagedResponse handle(FindAllDebtQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<Debt> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all Debts");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<DebtResponse> responses = pages.stream()
	.map(DebtMapper::toResponse)
	.toList();

	return DebtPagedResponse.from(
	pages,
	responses
	);
	}
}
