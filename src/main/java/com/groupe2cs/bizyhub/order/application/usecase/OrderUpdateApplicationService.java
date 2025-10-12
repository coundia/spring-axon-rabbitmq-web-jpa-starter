package com.groupe2cs.bizyhub.order.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.order.application.query.*;
import com.groupe2cs.bizyhub.order.application.command.*;
import com.groupe2cs.bizyhub.order.domain.valueObject.*;
import com.groupe2cs.bizyhub.order.application.dto.*;
import com.groupe2cs.bizyhub.order.application.mapper.*;

import java.util.List;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

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
