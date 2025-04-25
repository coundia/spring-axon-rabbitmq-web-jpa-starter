package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenCreateApplicationService {
private final CommandGateway commandGateway;

public RefreshTokenResponse createRefreshToken(RefreshTokenRequest request,
String createdBy ){

CreateRefreshTokenCommand command = RefreshTokenMapper.toCommand(
request
);

if(createdBy != null) {
	command.setCreatedBy( RefreshTokenCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);
return RefreshTokenMapper.toResponse(command);
}


}
