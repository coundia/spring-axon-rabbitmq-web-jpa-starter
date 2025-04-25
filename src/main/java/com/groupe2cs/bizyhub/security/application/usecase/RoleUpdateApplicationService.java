package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.security.application.query.*;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public RoleResponse updateRole(RoleId id,RoleRequest request,
String createdBy 
){

UpdateRoleCommand command = RoleMapper.toUpdateCommand(
id,
request
);

if(createdBy != null) {
command.setCreatedBy( RoleCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);

return RoleMapper.toResponse(command);
}

}
