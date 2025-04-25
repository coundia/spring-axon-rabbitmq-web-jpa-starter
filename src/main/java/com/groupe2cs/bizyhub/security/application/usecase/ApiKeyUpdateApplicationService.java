package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApiKeyUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public ApiKeyResponse updateApiKey(ApiKeyId id,ApiKeyRequest request,
String createdBy 
){

UpdateApiKeyCommand command = ApiKeyMapper.toUpdateCommand(
id,
request
);

if(createdBy != null) {
command.setCreatedBy( ApiKeyCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);

return ApiKeyMapper.toResponse(command);
}

}
