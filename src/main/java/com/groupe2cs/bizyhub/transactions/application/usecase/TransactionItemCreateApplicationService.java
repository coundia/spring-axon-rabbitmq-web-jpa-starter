package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionItemCreateApplicationService {
private final CommandGateway commandGateway;

public TransactionItemResponse createTransactionItem(TransactionItemRequest request,
MetaRequest metaRequest
){

CreateTransactionItemCommand command = TransactionItemMapper.toCommand(
request
);

command.setCreatedBy(TransactionItemCreatedBy.create(metaRequest.getUserId()));
command.setTenant(TransactionItemTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return TransactionItemMapper.toResponse(command);
}


}
