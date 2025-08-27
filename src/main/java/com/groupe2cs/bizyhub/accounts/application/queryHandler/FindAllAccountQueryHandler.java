package com.groupe2cs.bizyhub.accounts.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.repository.*;
import com.groupe2cs.bizyhub.accounts.application.query.*;
import com.groupe2cs.bizyhub.accounts.infrastructure.entity.*;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllAccountQueryHandler {

private final AccountRepository repository;

public FindAllAccountQueryHandler(AccountRepository repository) {
	this.repository = repository;
}

@QueryHandler
public AccountPagedResponse handle(FindAllAccountQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<Account> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all Accounts");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<AccountResponse> responses = pages.stream()
	.map(AccountMapper::toResponse)
	.toList();

	return AccountPagedResponse.from(
	pages,
	responses
	);
	}
}
