package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantCreateApplicationService {
private final CommandGateway commandGateway;

public TenantResponse createTenant(TenantRequest request,
String createdBy ){

CreateTenantCommand command = TenantMapper.toCommand(
request
);

if(createdBy != null) {
	command.setCreatedBy( TenantCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);
return TenantMapper.toResponse(command);
}


}
