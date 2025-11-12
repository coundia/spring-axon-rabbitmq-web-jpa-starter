package com.groupe2cs.bizyhub.order.application.queryHandler;

import com.groupe2cs.bizyhub.order.application.dto.OrderResponse;
import com.groupe2cs.bizyhub.order.application.mapper.OrderMapper;
import com.groupe2cs.bizyhub.order.application.query.FindByOrderTypeOrderQuery;
import com.groupe2cs.bizyhub.order.infrastructure.entity.Order;
import com.groupe2cs.bizyhub.order.infrastructure.repository.OrderRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByOrderTypeOrderHandler {

	private final OrderRepository repository;

	@QueryHandler
	public List<OrderResponse> handle(FindByOrderTypeOrderQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Order> entities = null;
		String value = query.getTypeOrder().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByTypeOrderAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByTypeOrderAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(OrderMapper::toResponse)
				.toList();
	}


}
