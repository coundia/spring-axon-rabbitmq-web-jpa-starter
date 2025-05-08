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
public class FindAllAccountUserQueryHandler {

private final AccountUserRepository repository;

public FindAllAccountUserQueryHandler(AccountUserRepository repository) {
	this.repository = repository;
}

@QueryHandler
public AccountUserPagedResponse handle(FindAllAccountUserQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<AccountUser> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all AccountUsers");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<AccountUserResponse> responses = pages.stream()
	.map(AccountUserMapper::toResponse)
	.toList();

	return AccountUserPagedResponse.from(
	pages,
	responses
	);
	}
}
