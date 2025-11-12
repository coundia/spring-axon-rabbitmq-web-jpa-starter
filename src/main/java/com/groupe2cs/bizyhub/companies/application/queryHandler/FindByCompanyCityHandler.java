package com.groupe2cs.bizyhub.companies.application.queryHandler;

import com.groupe2cs.bizyhub.companies.application.dto.CompanyResponse;
import com.groupe2cs.bizyhub.companies.application.mapper.CompanyMapper;
import com.groupe2cs.bizyhub.companies.application.query.FindByCompanyCityQuery;
import com.groupe2cs.bizyhub.companies.infrastructure.entity.Company;
import com.groupe2cs.bizyhub.companies.infrastructure.repository.CompanyRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByCompanyCityHandler {

	private final CompanyRepository repository;

	@QueryHandler
	public List<CompanyResponse> handle(FindByCompanyCityQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Company> entities = null;
		String value = query.getCity().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByCityAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByCityAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(CompanyMapper::toResponse)
				.toList();
	}


}
