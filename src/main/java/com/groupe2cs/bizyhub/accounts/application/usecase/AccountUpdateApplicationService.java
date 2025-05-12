package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.accounts.application.query.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public AccountResponse updateAccount(AccountId id,AccountRequest request,
MetaRequest metaRequest
){

UpdateAccountCommand command = AccountMapper.toUpdateCommand(
id,
request
);

if(metaRequest.getTenantId() != null) {
	//command.setTenant(AccountTenant.create(metaRequest.getTenantId()));
}

commandGateway.sendAndWait(command);

return AccountMapper.toResponse(command);
}

}
