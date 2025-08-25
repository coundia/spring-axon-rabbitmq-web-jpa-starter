package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public TransactionResponse updateTransaction(TransactionId id,TransactionRequest request,
MetaRequest metaRequest
){

UpdateTransactionCommand command = TransactionMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(TransactionCreatedBy.create(metaRequest.getUserId()));
command.setTenant(TransactionTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return TransactionMapper.toResponse(command);
}

}
