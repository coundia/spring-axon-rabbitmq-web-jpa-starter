package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.dto.SaleUserPagedResponse;
import com.groupe2cs.bizyhub.sales.application.dto.SaleUserResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleUserMapper;
import com.groupe2cs.bizyhub.sales.application.query.FindAllSaleUserQuery;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.SaleUser;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleUserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


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

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all SaleUsers");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {
			log.info("Non-admin user, fetching SaleUsers by userId");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);
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
