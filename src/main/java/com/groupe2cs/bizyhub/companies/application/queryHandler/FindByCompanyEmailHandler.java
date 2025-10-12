package com.groupe2cs.bizyhub.companies.application.queryHandler;

import com.groupe2cs.bizyhub.companies.application.mapper.*;
import com.groupe2cs.bizyhub.companies.domain.valueObject.*;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.*;
import com.groupe2cs.bizyhub.companies.application.dto.*;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.*;
import com.groupe2cs.bizyhub.companies.application.query.*;
import com.groupe2cs.bizyhub.companies.domain.exception.*;
import com.groupe2cs.bizyhub.shared.application.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import org.axonframework.queryhandling.QueryHandler;


@Component
@RequiredArgsConstructor
public class FindByCompanyEmailHandler {

	private final CompanyRepository repository;

	@QueryHandler
	public List<CompanyResponse> handle(FindByCompanyEmailQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Company> entities = null;
		String value = query.getEmail().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByEmailAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByEmailAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CompanyMapper::toResponse)
				.toList();
	}


}
