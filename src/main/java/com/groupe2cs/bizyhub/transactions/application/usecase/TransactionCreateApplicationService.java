package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.command.CreateTransactionCommand;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionRequest;
import com.groupe2cs.bizyhub.transactions.application.dto.TransactionResponse;
import com.groupe2cs.bizyhub.transactions.application.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionCreateApplicationService {
private final CommandGateway commandGateway;

public TransactionResponse createTransaction(TransactionRequest request){

CreateTransactionCommand command = TransactionMapper.toCommand(
request
);
commandGateway.sendAndWait(command);
return TransactionMapper.toResponse(command);
}


}
