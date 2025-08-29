package com.groupe2cs.bizyhub.customers.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.customers.application.mapper.*;
import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.customers.application.command.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerCreateApplicationService {
private final CommandGateway commandGateway;

public CustomerResponse createCustomer(CustomerRequest request,
MetaRequest metaRequest
){

CreateCustomerCommand command = CustomerMapper.toCommand(
request
);

command.setCreatedBy(CustomerCreatedBy.create(metaRequest.getUserId()));
command.setTenant(CustomerTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return CustomerMapper.toResponse(command);
}


}
