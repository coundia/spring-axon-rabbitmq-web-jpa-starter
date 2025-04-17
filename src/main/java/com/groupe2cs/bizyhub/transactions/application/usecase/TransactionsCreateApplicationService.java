package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionsCreateApplicationService {
private final CommandGateway commandGateway;

public TransactionsResponse createTransactions(TransactionsRequest request){

CreateTransactionsCommand command = TransactionsMapper.toCommand(
request
);
commandGateway.sendAndWait(command);
return TransactionsMapper.toResponse(command);
}


}
