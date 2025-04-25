package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PasswordResetCreateApplicationService {
private final CommandGateway commandGateway;

public PasswordResetResponse createPasswordReset(PasswordResetRequest request,
String createdBy ){

CreatePasswordResetCommand command = PasswordResetMapper.toCommand(
request
);

if(createdBy != null) {
	command.setCreatedBy( PasswordResetCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);
return PasswordResetMapper.toResponse(command);
}


}
