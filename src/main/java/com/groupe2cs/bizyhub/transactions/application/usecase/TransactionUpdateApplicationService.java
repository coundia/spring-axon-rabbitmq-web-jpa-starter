package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.transactions.application.mapper.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;

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
String createdBy 
){

UpdateTransactionCommand command = TransactionMapper.toUpdateCommand(
id,
request
);

if(createdBy != null) {
command.setCreatedBy( TransactionCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);

return TransactionMapper.toResponse(command);
}

}
