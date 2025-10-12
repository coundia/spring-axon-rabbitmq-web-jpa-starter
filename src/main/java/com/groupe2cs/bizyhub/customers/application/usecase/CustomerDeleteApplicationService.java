package com.groupe2cs.bizyhub.customers.application.usecase;

import com.groupe2cs.bizyhub.customers.application.command.DeleteCustomerCommand;
import com.groupe2cs.bizyhub.customers.domain.valueObject.CustomerId;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteCustomer(CustomerId idVo, MetaRequest metaRequest) {

		DeleteCustomerCommand command = new DeleteCustomerCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
