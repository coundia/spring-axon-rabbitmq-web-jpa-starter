package com.groupe2cs.bizyhub.order.application.queryHandler;

import com.groupe2cs.bizyhub.order.application.dto.OrderPagedResponse;
import com.groupe2cs.bizyhub.order.application.dto.OrderResponse;
import com.groupe2cs.bizyhub.order.application.mapper.OrderMapper;
import com.groupe2cs.bizyhub.order.application.query.FindAllOrderQuery;
import com.groupe2cs.bizyhub.order.infrastructure.entity.Order;
import com.groupe2cs.bizyhub.order.infrastructure.repository.OrderRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
public class FindAllOrderQueryHandler {

	private final OrderRepository repository;

	public FindAllOrderQueryHandler(OrderRepository repository) {
		this.repository = repository;
	}

	@QueryHandler
	public OrderPagedResponse handle(FindAllOrderQuery query) {
		int limit = query.getLimit();
		int offset = query.getPage() * limit;
		MetaRequest metaRequest = query.getMetaRequest();

		PageRequest pageable = PageRequest.of(offset / limit, limit);
		Page<Order> pages = null;

		if (metaRequest.isAdmin()) {

			log.info("Admin user, fetching all Orders");
			pages = repository.findAllByTenantId(metaRequest.getTenantId(), pageable);
		} else {

			log.info("User, fetching own  ");
			pages = repository.findByCreatedById(metaRequest.getUserId(), pageable);


		}

		List<OrderResponse> responses = pages.stream()
				.map(OrderMapper::toResponse)
				.toList();

		return OrderPagedResponse.from(
				pages,
				responses
		);
	}
}
