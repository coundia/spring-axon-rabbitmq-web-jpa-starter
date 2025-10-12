package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.FileStorageService;
import com.groupe2cs.bizyhub.transactions.application.command.UpdateTransactionItemCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionItemResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionItemMapper;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionItemCreatedBy;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionItemId;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.TransactionItemTenant;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionItemUpdateApplicationService {

	private final FileStorageService fileStorageService;
	private final CommandGateway commandGateway;


	public TransactionItemResponse updateTransactionItem(TransactionItemId id, TransactionItemRequest request,
														 MetaRequest metaRequest
	) {

		UpdateTransactionItemCommand command = TransactionItemMapper.toUpdateCommand(
				id,
				request
		);

		command.setCreatedBy(TransactionItemCreatedBy.create(metaRequest.getUserId()));
		command.setTenant(TransactionItemTenant.create(metaRequest.getTenantId()));

		commandGateway.sendAndWait(command);

		return TransactionItemMapper.toResponse(command);
	}

}
