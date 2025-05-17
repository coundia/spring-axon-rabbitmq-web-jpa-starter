package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.application.command.CreateTenantCommand;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantRequest;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.mapper.TenantMapper;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantCreatedBy;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantCreateApplicationService {
	private final CommandGateway commandGateway;

	public TenantResponse createTenant(TenantRequest request,
									   MetaRequest metaRequest
	) {

		CreateTenantCommand command = TenantMapper.toCommand(
				request
		);

		command.setCreatedBy(TenantCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(TenantTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return TenantMapper.toResponse(command);
	}


}
