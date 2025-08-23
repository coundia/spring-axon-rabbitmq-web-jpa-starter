package com.groupe2cs.bizyhub.companies.application.queryHandler;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.*;
import com.groupe2cs.bizyhub.companies.application.query.*;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
import com.groupe2cs.bizyhub.companies.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;

import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class FindAllCompanyQueryHandler {

private final CompanyRepository repository;

public FindAllCompanyQueryHandler(CompanyRepository repository) {
	this.repository = repository;
}

@QueryHandler
public CompanyPagedResponse handle(FindAllCompanyQuery query) {
int limit = query.getLimit();
int offset = query.getPage() * limit;
MetaRequest metaRequest = query.getMetaRequest();

PageRequest pageable = PageRequest.of(offset / limit, limit);
Page<Company> pages = null;

if(metaRequest.isAdmin()) {

 log.info("Admin user, fetching all Companys");
	pages = repository.findAllByTenantId( metaRequest.getTenantId(),pageable);
}else{
log.info("User, fetching own  ");
pages = repository.findByCreatedById(metaRequest.getUserId(),pageable);
}

List<CompanyResponse> responses = pages.stream()
	.map(CompanyMapper::toResponse)
	.toList();

	return CompanyPagedResponse.from(
	pages,
	responses
	);
	}
}
