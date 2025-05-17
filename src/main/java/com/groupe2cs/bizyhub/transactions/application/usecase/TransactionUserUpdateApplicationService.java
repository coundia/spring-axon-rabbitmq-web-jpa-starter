package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionUserCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionUserResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionUserMapper;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionUserId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionUserUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public TransactionUserResponse updateTransactionUser(TransactionUserId id, TransactionUserRequest request,
														 MetaRequest metaRequest
	) {

		UpdateTransactionUserCommand command = TransactionUserMapper.toUpdateCommand(
				id,
				request
		);

		if (metaRequest.getTenantId() != null) {
			//command.setTenant(TransactionUserTenant.create(metaRequest.getTenantId()));
		}

		commandGateway.sendAndWait(command);

		return TransactionUserMapper.toResponse(command);
	}

}
