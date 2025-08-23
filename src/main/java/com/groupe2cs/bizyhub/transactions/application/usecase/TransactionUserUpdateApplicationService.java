package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionUserUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public TransactionUserResponse updateTransactionUser(TransactionUserId id,TransactionUserRequest request,
MetaRequest metaRequest
){

UpdateTransactionUserCommand command = TransactionUserMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(TransactionUserCreatedBy.create(metaRequest.getUserId()));
command.setTenant(TransactionUserTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return TransactionUserMapper.toResponse(command);
}

}
