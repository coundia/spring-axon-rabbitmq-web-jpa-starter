package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionCreateApplicationService {
private final CommandGateway commandGateway;

public TransactionResponse createTransaction(TransactionRequest request,
String createdBy ){

CreateTransactionCommand command = TransactionMapper.toCommand(
request
);

if(createdBy != null) {
	command.setCreatedBy( TransactionCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);
return TransactionMapper.toResponse(command);
}


}
