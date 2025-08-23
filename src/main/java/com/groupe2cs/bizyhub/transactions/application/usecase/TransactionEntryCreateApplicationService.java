package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionEntryCreateApplicationService {
private final CommandGateway commandGateway;

public TransactionEntryResponse createTransactionEntry(TransactionEntryRequest request,
MetaRequest metaRequest
){

CreateTransactionEntryCommand command = TransactionEntryMapper.toCommand(
request
);

command.setCreatedBy(TransactionEntryCreatedBy.create(metaRequest.getUserId()));
command.setTenant(TransactionEntryTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return TransactionEntryMapper.toResponse(command);
}


}
