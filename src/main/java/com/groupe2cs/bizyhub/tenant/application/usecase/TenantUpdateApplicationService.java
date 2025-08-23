package com.groupe2cs.bizyhub.tenant.application.usecase;

import com.groupe2cs.bizyhub.tenant.application.mapper.*;
import com.groupe2cs.bizyhub.tenant.application.dto.*;
import com.groupe2cs.bizyhub.tenant.application.query.*;
import com.groupe2cs.bizyhub.tenant.domain.valueObject.*;
import com.groupe2cs.bizyhub.shared.infrastructure.*;
import com.groupe2cs.bizyhub.shared.application.dto.MetaRequest;
import com.groupe2cs.bizyhub.tenant.application.command.*;
import java.util.List;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TenantUpdateApplicationService {

private final FileStorageService fileStorageService;
private final CommandGateway commandGateway;


public TenantResponse updateTenant(TenantId id,TenantRequest request,
MetaRequest metaRequest
){

UpdateTenantCommand command = TenantMapper.toUpdateCommand(
id,
request
);

command.setCreatedBy(TenantCreatedBy.create(metaRequest.getUserId()));
command.setTenant(TenantTenant.create(metaRequest.getTenantId()));

commandGateway.sendAndWait(command);

return TenantMapper.toResponse(command);
}

}
