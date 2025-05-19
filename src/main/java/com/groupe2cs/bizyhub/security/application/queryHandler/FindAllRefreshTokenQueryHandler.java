package com.groupe2cs.bizyhub.security.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.infrastructure.repository.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.infrastructure.entity.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllRefreshTokenQueryHandler {

private final RefreshTokenRepository repository;

public FindAllRefreshTokenQueryHandler(RefreshTokenRepository repository) {
	this.repository = repository;
}

@QueryHandler
public RefreshTokenPagedResponse handle(FindAllRefreshTokenQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<RefreshToken> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all RefreshTokens");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<RefreshTokenResponse> responses = pages.stream()
	.map(RefreshTokenMapper::toResponse)
	.toList();

	return RefreshTokenPagedResponse.from(
	pages,
	responses
	);
	}
}
