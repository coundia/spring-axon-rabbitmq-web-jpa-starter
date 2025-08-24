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
public class ApiKeyCreateApplicationService {
private final CommandGateway commandGateway;

public ApiKeyResponse createApiKey(ApiKeyRequest request,
MetaRequest metaRequest
){

CreateApiKeyCommand command = ApiKeyMapper.toCommand(
request
);

command.setCreatedBy(ApiKeyCreatedBy.create(metaRequest.getUserId()));
command.setTenant(ApiKeyTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);
return ApiKeyMapper.toResponse(command);
}


}
