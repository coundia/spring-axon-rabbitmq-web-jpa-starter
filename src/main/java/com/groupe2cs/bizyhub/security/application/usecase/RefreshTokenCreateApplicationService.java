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
public class RefreshTokenCreateApplicationService {
private final CommandGateway commandGateway;

public RefreshTokenResponse createRefreshToken(RefreshTokenRequest request){

CreateRefreshTokenCommand command = RefreshTokenMapper.toCommand(
request
);
commandGateway.sendAndWait(command);
return RefreshTokenMapper.toResponse(command);
}


}
