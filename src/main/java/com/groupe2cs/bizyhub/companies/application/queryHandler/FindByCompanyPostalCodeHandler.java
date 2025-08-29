package com.groupe2cs.bizyhub.companies.application.queryHandler;

import com.groupe2cs.bizyhub.companies.application.dto.CompanyResponse;
import com.groupe2cs.bizyhub.companies.application.mapper.CompanyMapper;
import com.groupe2cs.bizyhub.companies.application.query.FindByCompanyPostalCodeQuery;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.Company;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByCompanyPostalCodeHandler {

	private final CompanyRepository repository;

	@QueryHandler
	public List<CompanyResponse> handle(FindByCompanyPostalCodeQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Company> entities = null;
		String value = query.getPostalCode().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByPostalCodeAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByPostalCodeAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CompanyMapper::toResponse)
				.toList();
	}


}
