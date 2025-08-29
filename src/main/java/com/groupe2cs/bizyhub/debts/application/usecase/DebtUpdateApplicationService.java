package com.groupe2cs.bizyhub.debts.application.usecase;

import com.groupe2cs.bizyhub.debts.application.command.UpdateDebtCommand;
import com.groupe2cs.bizyhub.debts.application.dto.DebtRequest;
import com.groupe2cs.bizyhub.debts.application.dto.DebtResponse;
import com.groupe2cs.bizyhub.debts.application.mapper.DebtMapper;
import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtCreatedBy;
import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtId;
import com.groupe2cs.bizyhub.debts.domain.valueObject.DebtTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DebtUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public DebtResponse updateDebt(DebtId id, DebtRequest request,
								   MetaRequest metaRequest
	) {

		UpdateDebtCommand command = DebtMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(DebtCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(DebtTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return DebtMapper.toResponse(command);
	}

}
