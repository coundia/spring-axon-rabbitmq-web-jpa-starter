package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PasswordResetCreateApplicationService {
private final CommandGateway commandGateway;

public PasswordResetResponse createPasswordReset(PasswordResetRequest request,
MetaRequest metaRequest
){

CreatePasswordResetCommand command = PasswordResetMapper.toCommand(
request
);

command.setCreatedBy(PasswordResetCreatedBy.create(metaRequest.getUserId()));
command.setTenant(PasswordResetTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return PasswordResetMapper.toResponse(command);
}


}
