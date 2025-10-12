package com.groupe2cs.bizyhub.customers.application.usecase;

import com.groupe2cs.bizyhub.customers.application.command.CreateCustomerCommand;
import com.groupe2cs.bizyhub.customers.application.dto.CustomerRequest;
import com.groupe2cs.bizyhub.customers.application.dto.CustomerResponse;
import com.groupe2cs.bizyhub.customers.application.mapper.CustomerMapper;
import com.groupe2cs.bizyhub.customers.domain.valueObject.CustomerCreatedBy;
import com.groupe2cs.bizyhub.customers.domain.valueObject.CustomerTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerCreateApplicationService {
	private final CommandGateway commandGateway;

	public CustomerResponse createCustomer(CustomerRequest request,
										   MetaRequest metaRequest
	) {

		CreateCustomerCommand command = CustomerMapper.toCommand(
				request
		);

		command.setCreatedBy(CustomerCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(CustomerTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return CustomerMapper.toResponse(command);
	}


}
