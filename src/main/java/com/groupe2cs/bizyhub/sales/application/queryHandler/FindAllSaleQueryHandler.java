package com.groupe2cs.bizyhub.sales.application.queryHandler;

import com.groupe2cs.bizyhub.sales.application.dto.SalePagedResponse;
import com.groupe2cs.bizyhub.sales.application.dto.SaleResponse;
import com.groupe2cs.bizyhub.sales.application.mapper.SaleMapper;
import com.groupe2cs.bizyhub.sales.application.query.FindAllSaleQuery;
import com.groupe2cs.bizyhub.sales.infrastructure.entity.Sale;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleRepository;
import com.groupe2cs.bizyhub.sales.infrastructure.repository.SaleUserRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class FindAllSaleQueryHandler {

	private final SaleRepository repository;
	private final SaleUserRepository saleUserRepository;


	@QueryHandler
	public SalePagedResponse handle(FindAllSaleQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Sale> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Sales");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {
			log.info("Non-admin user, fetching Sales by userId");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);
		}
		Page<Sale> pagesShared =  saleUserRepository.findByUsersIdAndTenantId(metaRequest.getUserId(), metaRequest.getTenantId());


		List<SaleResponse> responses = pages.stream()
				.map(SaleMapper::toResponse)
				.toList();

		return SalePagedResponse.from(
				pages,
				responses
		);
	}
}
