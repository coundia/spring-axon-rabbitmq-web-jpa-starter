package com.groupe2cs.bizyhub.order.application.usecase;

import com.groupe2cs.bizyhub.order.application.command.DeleteOrderCommand;
import com.groupe2cs.bizyhub.order.domain.valueObject.OrderId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteOrder(OrderId idVo, MetaRequest metaRequest) {

		DeleteOrderCommand command = new DeleteOrderCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
