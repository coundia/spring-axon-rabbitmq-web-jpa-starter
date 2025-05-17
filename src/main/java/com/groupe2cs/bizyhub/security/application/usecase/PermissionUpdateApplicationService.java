package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PermissionUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public PermissionResponse updatePermission(PermissionId id,PermissionRequest request,
MetaRequest metaRequest
){

UpdatePermissionCommand command = PermissionMapper.toUpdateCommand(
id,
request
);

if(metaRequest.getTenantId() != null) {
	//command.setTenant(PermissionTenant.create(metaRequest.getTenantId()));
}

commandGateway.sendAndWait(command);

return PermissionMapper.toResponse(command);
}

}
