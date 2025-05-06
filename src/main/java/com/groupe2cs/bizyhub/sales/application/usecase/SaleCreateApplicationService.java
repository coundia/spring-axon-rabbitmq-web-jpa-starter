package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.application.command.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleCreateApplicationService {
private final CommandGateway commandGateway;

public SaleResponse createSale(SaleRequest request,
MetaRequest metaRequest
){

CreateSaleCommand command = SaleMapper.toCommand(
request
);

command.setCreatedBy(SaleCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(SaleTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return SaleMapper.toResponse(command);
}


}
