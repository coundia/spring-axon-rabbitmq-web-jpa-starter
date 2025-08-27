package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VerificationCodeCreateApplicationService {
private final CommandGateway commandGateway;

public VerificationCodeResponse createVerificationCode(VerificationCodeRequest request,
MetaRequest metaRequest
){

CreateVerificationCodeCommand command = VerificationCodeMapper.toCommand(
request
);

command.setCreatedBy(VerificationCodeCreatedBy.create(metaRequest.getUserId()));
command.setTenant(VerificationCodeTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return VerificationCodeMapper.toResponse(command);
}


}
