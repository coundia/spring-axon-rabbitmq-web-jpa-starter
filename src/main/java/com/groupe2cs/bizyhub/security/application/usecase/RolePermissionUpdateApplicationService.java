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
public class RolePermissionUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public RolePermissionResponse updateRolePermission(RolePermissionId id,RolePermissionRequest request,
MetaRequest metaRequest
){

UpdateRolePermissionCommand command = RolePermissionMapper.toUpdateCommand(
id,
request
);

if(metaRequest.getTenantId() != null) {
	//command.setTenant(RolePermissionTenant.create(metaRequest.getTenantId()));
}

commandGateway.sendAndWait(command);

return RolePermissionMapper.toResponse(command);
}

}
