package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionUserCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionUserMapper;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionUserCreatedBy;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionUserTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionUserCreateApplicationService {
	private final CommandGateway commandGateway;

	public TransactionUserResponse createTransactionUser(TransactionUserRequest request,
														 MetaRequest metaRequest
	) {

		CreateTransactionUserCommand command = TransactionUserMapper.toCommand(
				request
		);

		command.setCreatedBy(TransactionUserCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(TransactionUserTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);
		return TransactionUserMapper.toResponse(command);
	}


}
