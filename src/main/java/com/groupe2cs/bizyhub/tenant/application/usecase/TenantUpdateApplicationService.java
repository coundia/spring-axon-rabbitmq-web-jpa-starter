package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import com.groupe2cs.bizyhub.tenant.application.command.UpdateTenantCommand;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantRequest;
import com.groupe2cs.bizyhub.tenant.application.dto.TenantResponse;
import com.groupe2cs.bizyhub.tenant.application.mapper.TenantMapper;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantCreatedBy;
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
									   String createdBy
	) {

		UpdateTenantCommand command = TenantMapper.toUpdateCommand(
				id,
				request
		);

		if (createdBy != null) {
			command.setCreatedBy(TenantCreatedBy.create(createdBy));
		}

		commandGateway.sendAndWait(command);

		return TenantMapper.toResponse(command);
	}

}
