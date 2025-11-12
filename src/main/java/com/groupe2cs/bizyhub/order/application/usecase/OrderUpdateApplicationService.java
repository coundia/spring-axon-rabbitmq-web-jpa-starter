package com.groupe2cs.bizyhub.order.application.usecase;

import com.groupe2cs.bizyhub.order.application.command.UpdateOrderCommand;
import com.groupe2cs.bizyhub.order.application.dto.OrderRequest;
import com.groupe2cs.bizyhub.order.application.dto.OrderResponse;
import com.groupe2cs.bizyhub.order.application.mapper.OrderMapper;
import com.groupe2cs.bizyhub.order.domain.valueObject.OrderCreatedBy;
import com.groupe2cs.bizyhub.order.domain.valueObject.OrderId;
import com.groupe2cs.bizyhub.order.domain.valueObject.OrderTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public OrderResponse updateOrder(OrderId id, OrderRequest request,
									 MetaRequest metaRequest
	) {

		UpdateOrderCommand command = OrderMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(OrderCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(OrderTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return OrderMapper.toResponse(command);
	}

}
