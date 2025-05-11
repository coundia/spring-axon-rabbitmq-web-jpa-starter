package com.groupe2cs.bizyhub.sales.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.sales.application.mapper.*;
import com.groupe2cs.bizyhub.sales.domain.valueObject.*;
import com.groupe2cs.bizyhub.sales.application.command.*;
import com.groupe2cs.bizyhub.sales.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SaleUserCreateApplicationService {
private final CommandGateway commandGateway;

public SaleUserResponse createSaleUser(SaleUserRequest request,
MetaRequest metaRequest
){

CreateSaleUserCommand command = SaleUserMapper.toCommand(
request
);

command.setCreatedBy(SaleUserCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(SaleUserTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return SaleUserMapper.toResponse(command);
}


}
