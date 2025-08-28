package com.groupe2cs.bizyhub.security.application.usecase;

import com.groupe2cs.bizyhub.security.application.mapper.*;
import com.groupe2cs.bizyhub.security.application.query.*;
import com.groupe2cs.bizyhub.security.application.dto.*;
import com.groupe2cs.bizyhub.security.domain.valueObject.*;
import com.groupe2cs.bizyhub.security.application.command.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import java.util.List;
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
MetaRequest metaRequest
){

UpdateRoleCommand command = RoleMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(RoleCreatedBy.create(metaRequest.getUserId()));
command.setTenant(RoleTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return RoleMapper.toResponse(command);
}

}
