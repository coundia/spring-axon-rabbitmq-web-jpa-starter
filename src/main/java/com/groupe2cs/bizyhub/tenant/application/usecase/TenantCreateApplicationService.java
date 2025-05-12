package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantCreateApplicationService {
private final CommandGateway commandGateway;

public TenantResponse createTenant(TenantRequest request,
MetaRequest metaRequest
){

CreateTenantCommand command = TenantMapper.toCommand(
request
);

command.setCreatedBy(TenantCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(TenantTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return TenantMapper.toResponse(command);
}


}
