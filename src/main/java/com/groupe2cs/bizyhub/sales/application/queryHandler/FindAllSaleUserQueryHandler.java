package com.groupe2cs.bizyhub.sales.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.*;
import com.groupe2cs.bizyhub.sales.application.query.*;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllSaleUserQueryHandler {

private final SaleUserRepository repository;

public FindAllSaleUserQueryHandler(SaleUserRepository repository) {
	this.repository = repository;
}

@QueryHandler
public SaleUserPagedResponse handle(FindAllSaleUserQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<SaleUser> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all SaleUsers");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
 log.info("User, fetching own  ");
  	pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<SaleUserResponse> responses = pages.stream()
	.map(SaleUserMapper::toResponse)
	.toList();

	return SaleUserPagedResponse.from(
	pages,
	responses
	);
	}
}
