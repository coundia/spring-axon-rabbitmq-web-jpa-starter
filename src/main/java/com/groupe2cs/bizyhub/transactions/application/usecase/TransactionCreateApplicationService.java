package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionCreateApplicationService {
private final CommandGateway commandGateway;

public TransactionResponse createTransaction(TransactionRequest request,
MetaRequest metaRequest
){

CreateTransactionCommand command = TransactionMapper.toCommand(
request
);

command.setCreatedBy(TransactionCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(TransactionTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return TransactionMapper.toResponse(command);
}


}
