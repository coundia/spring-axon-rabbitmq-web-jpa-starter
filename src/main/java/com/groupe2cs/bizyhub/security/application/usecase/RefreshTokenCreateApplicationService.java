package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.command.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RefreshTokenCreateApplicationService {
private final CommandGateway commandGateway;

public RefreshTokenResponse createRefreshToken(RefreshTokenRequest request,
MetaRequest metaRequest
){

CreateRefreshTokenCommand command = RefreshTokenMapper.toCommand(
request
);

command.setCreatedBy(RefreshTokenCreatedBy.create(metaRequest.getUserId()));
	command.setTenant(RefreshTokenTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return RefreshTokenMapper.toResponse(command);
}


}
