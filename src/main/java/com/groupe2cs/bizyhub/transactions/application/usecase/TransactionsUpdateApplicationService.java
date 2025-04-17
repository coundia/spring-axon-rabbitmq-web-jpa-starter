package com.groupe2cs.bizyhub.transactions.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.transactions.application.command.*;
import com.groupe2cs.bizyhub.transactions.domain.valueObject.*;
import com.groupe2cs.bizyhub.transactions.application.query.*;
import com.groupe2cs.bizyhub.transactions.application.dto.*;
import com.groupe2cs.bizyhub.transactions.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransactionsUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public TransactionsResponse updateTransactions(TransactionsId id,TransactionsRequest request){

UpdateTransactionsCommand command = TransactionsMapper.toUpdateCommand(
id,
request
);

commandGateway.sendAndWait(command);

return TransactionsMapper.toResponse(command);
}

}
