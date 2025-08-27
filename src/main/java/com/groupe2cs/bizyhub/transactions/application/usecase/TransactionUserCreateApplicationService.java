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
public class TransactionUserCreateApplicationService {
private final CommandGateway commandGateway;

public TransactionUserResponse createTransactionUser(TransactionUserRequest request,
MetaRequest metaRequest
){

CreateTransactionUserCommand command = TransactionUserMapper.toCommand(
request
);

command.setCreatedBy(TransactionUserCreatedBy.create(metaRequest.getUserId()));
command.setTenant(TransactionUserTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return TransactionUserMapper.toResponse(command);
}


}
