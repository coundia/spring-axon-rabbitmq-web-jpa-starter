package com.groupe2cs.bizyhub.customers.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.customers.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.customers.application.mapper.*;
import com.groupe2cs.bizyhub.customers.application.query.*;
import com.groupe2cs.bizyhub.customers.domain.valueObject.*;
import com.groupe2cs.bizyhub.customers.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerDeleteApplicationService {

private final CommandGateway commandGateway;

public void deleteCustomer(CustomerId idVo, MetaRequest metaRequest) {

DeleteCustomerCommand command = new DeleteCustomerCommand(idVo);
commandGateway.sendAndWait(command);
}
}
