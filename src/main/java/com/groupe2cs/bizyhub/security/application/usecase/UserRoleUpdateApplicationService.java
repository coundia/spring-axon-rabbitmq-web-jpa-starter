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
public class UserRoleUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public UserRoleResponse updateUserRole(UserRoleId id,UserRoleRequest request,
String createdBy 
){

UpdateUserRoleCommand command = UserRoleMapper.toUpdateCommand(
id,
request
);

if(createdBy != null) {
command.setCreatedBy( UserRoleCreatedBy.create(createdBy));
}

commandGateway.sendAndWait(command);

return UserRoleMapper.toResponse(command);
}

}
