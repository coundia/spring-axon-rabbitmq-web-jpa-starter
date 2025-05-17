package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import com.groupe2cs.bizyhub.tenant.application.command.UpdateTenantCommand;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantRequest;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.mapper.TenantMapper;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public TenantResponse updateTenant(TenantId id, TenantRequest request,
									   MetaRequest metaRequest
	) {

		UpdateTenantCommand command = TenantMapper.toUpdateCommand(
				id,
				request
		);

		if (metaRequest.getTenantId() != null) {
			//command.setTenant(TenantTenant.create(metaRequest.getTenantId()));
		}

		commandGateway.sendAndWait(command);

		return TenantMapper.toResponse(command);
	}

}
