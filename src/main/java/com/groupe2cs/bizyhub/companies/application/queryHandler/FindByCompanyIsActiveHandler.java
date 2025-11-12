package com.groupe2cs.bizyhub.companies.application.queryHandler;

import com.groupe2cs.bizyhub.companies.application.dto.CompanyResponse;
import com.groupe2cs.bizyhub.companies.application.mapper.CompanyMapper;
import com.groupe2cs.bizyhub.companies.application.query.FindByCompanyIsActiveQuery;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.Company;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByCompanyIsActiveHandler {

	private final CompanyRepository repository;

	@QueryHandler
	public List<CompanyResponse> handle(FindByCompanyIsActiveQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Company> entities = null;
		Boolean value = query.getIsActive().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByIsActiveAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByIsActiveAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CompanyMapper::toResponse)
				.toList();
	}


}
