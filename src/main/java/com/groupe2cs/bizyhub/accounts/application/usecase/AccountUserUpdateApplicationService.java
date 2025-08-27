package com.groupe2cs.bizyhub.accounts.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.accounts.application.query.*;
import com.groupe2cs.bizyhub.accounts.application.dto.*;
import com.groupe2cs.bizyhub.accounts.domain.valueObject.*;
import com.groupe2cs.bizyhub.accounts.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.accounts.application.mapper.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountUserUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public AccountUserResponse updateAccountUser(AccountUserId id,AccountUserRequest request,
MetaRequest metaRequest
){

UpdateAccountUserCommand command = AccountUserMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(AccountUserCreatedBy.create(metaRequest.getUserId()));
command.setTenant(AccountUserTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return AccountUserMapper.toResponse(command);
}

}
