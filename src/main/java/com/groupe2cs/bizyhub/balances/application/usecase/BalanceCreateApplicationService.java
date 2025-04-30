package com.groupe2cs.bizyhub.balances.application.usecase;

import com.groupe2cs.bizyhub.balances.application.command.CreateBalanceCommand;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceRequest;
import com.groupe2cs.bizyhub.balances.application.dto.BalanceResponse;
import com.groupe2cs.bizyhub.balances.application.mapper.BalanceMapper;
import com.groupe2cs.bizyhub.balances.domain.valueObject.BalanceCreatedBy;
import com.groupe2cs.bizyhub.balances.domain.valueObject.BalanceTenant;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BalanceCreateApplicationService {
	private final CommandGateway commandGateway;

	public BalanceResponse createBalance(BalanceRequest request,
										 MetaRequest metaRequest
	) {

		CreateBalanceCommand command = BalanceMapper.toCommand(
				request
		);

		command.setCreatedBy(BalanceCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(BalanceTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return BalanceMapper.toResponse(command);
	}


}
