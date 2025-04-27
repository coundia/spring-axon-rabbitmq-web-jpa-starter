package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.application.command.DeleteTenantCommand;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.TenantId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TenantDeleteApplicationService {

	private final CommandGateway commandGateway;

	public void deleteTenant(TenantId idVo, MetaRequest metaRequest) {

		DeleteTenantCommand command = new DeleteTenantCommand(idVo);
		commandGateway.sendAndWait(command);
	}
}
