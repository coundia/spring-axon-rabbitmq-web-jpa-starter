package com.groupe2cs.bizyhub.order.application.queryHandler;

import com.groupe2cs.bizyhub.order.application.dto.OrderResponse;
import com.groupe2cs.bizyhub.order.application.mapper.OrderMapper;
import com.groupe2cs.bizyhub.order.application.query.FindByOrderNotesQuery;
import com.groupe2cs.bizyhub.order.infrastructure.entity.Order;
import com.groupe2cs.bizyhub.order.infrastructure.repository.OrderRepository;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class FindByOrderNotesHandler {

	private final OrderRepository repository;

	@QueryHandler
	public List<OrderResponse> handle(FindByOrderNotesQuery query) {

		MetaRequest metaRequest = query.getMetaRequest();
		List<Order> entities = null;
		String value = query.getNotes().value();

		if (metaRequest.isAdmin()) {
			entities = repository.findByNotesAndTenantId(value, metaRequest.getTenantId());
		} else {
			entities = repository.findByNotesAndCreatedById(value, metaRequest.getUserId());
		}

		return entities.stream()
				.map(OrderMapper::toResponse)
				.toList();
	}


}
